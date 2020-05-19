import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    
    public static class DSU {
        int[] parent;

        public DSU() {
            parent = new int[10001];
            for (int i = 0; i < 10001; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    /**
     * Time - O(A log A), A is the sum of the length of accounts[i], Inverse-Ackermann function
     * Space - O(A)
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<String, String>();
        Map<String, Integer> emailToID = new HashMap<String, Integer>();
        
        int id = 0;

        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id);
                    id++;
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> res = new HashMap<Integer, List<String>>();
        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            res.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
        }
        for (List<String> component : res.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }

        return new ArrayList(res.values());
    }
}