public class GasStation {
    
    /**
     * Time - O(n)
     * Space - O(1)
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];

            // If one couldn't get here,
            if (currTank < 0) {
                // Pick up the next station as the starting one,
                startingStation = i + 1;
                // and start with an empty tank;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startingStation : -1;
    }
}