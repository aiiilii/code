import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String cd : cpdomains) {
            int i = cd.indexOf(' '); // find the index of the first space ' '
            int n = Integer.valueOf(cd.substring(0, i)); // get the number of times visited
            String s = cd.substring(i + 1); // s is everything after the number and the space

            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1); // get everything after each dot '.', and put it in the map along with the number of times visited
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + n); // put all of s in to the map along with the number of times visited
        }

        List<String> res = new ArrayList<String>();
        for (String d : map.keySet()) {
            res.add(map.get(d) + " " + d);
        }
        return res;
    }
}