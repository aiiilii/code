import java.util.HashMap;
import java.util.Map;

public class PaintHouse {

    private int[][] costs;
    private Map<String, Integer> map;
    
    /**
     * Time - O(n), 
     * Space - O(n)
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        this.costs = costs;
        this.map = new HashMap<String, Integer>();

        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCost(int n, int color) {
        if (map.containsKey(getMapKey(n, color))) {
            return map.get(getMapKey(n, color));
        }

        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
            // do nothing;
        } else if (color == 0) { // red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2)); 
        } else { // blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }
        map.put(getMapKey(n, color), totalCost);

        return totalCost;
    }

    private String getMapKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }
}