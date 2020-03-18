import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    /**
     * Graph and Recursion approach
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        int idx = 0;
        for (List<String> eqList : equations) {
            double val = values[idx];
            idx ++;

            String src = eqList.get(0);
            String dest = eqList.get(1);

            Map<String, Double> adj = map.getOrDefault(src, new HashMap<String, Double>());
            adj.put(dest, val);
            map.put(src, adj);

            Map<String, Double> adjReverse = map.getOrDefault(dest, new HashMap<String, Double>());
            adjReverse.put(src, 1.0 / val);
            map.put(dest, adjReverse);
        }

        int size = queries.size();
        double[] res = new double[size];
        for (int i = 0; i < size; i++) {
            List<String> list = queries.get(i);
            String src = list.get(0);
            String dest = list.get(1);
            res[i] = -1.0;

            Map<String, Boolean> visited = new HashMap<String, Boolean>();
            for (String start : map.keySet()) {
                if (start.equals(src)) {
                    res[i] = solveEq(src, dest, map, visited, 1.0);
                    break;
                }
            }
        }
        return res;
    }

    private double solveEq(String curr, String dest, Map<String, Map<String, Double>> map, Map<String, Boolean> visited, double result) {
        if (curr.equals(dest)) {
            return result;
        }
        visited.put(curr, true);

        Map<String, Double> adj = map.get(curr);
        for (String neighbor : adj.keySet()) {
            if (!visited.containsKey(neighbor)) {
                double temp = solveEq(neighbor, dest, map, visited, result * adj.get(neighbor));
                if (temp != -1.0) {
                    return temp;
                }
            }
        }
        return -1.0;
    }
}