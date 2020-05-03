public class BrokenCalculator {

    /**
     * Time - O(log Y)
     * Space - O(1)
     * @param X
     * @param Y
     * @return
     */
    public int brokenCalc(int X, int Y) {
        int res = 0;

        while (Y > X) {
            res ++;
            if (Y % 2 == 1) {
                Y ++;
            } else {
                Y /= 2;
            }
        }
        return res + X - Y;
    }
}