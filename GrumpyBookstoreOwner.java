public class GrumpyBookstoreOwner {

    /**
     * Sliding Window
     * Time - O(n)
     * Space - O(1)
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatistfied(int[] customers, int[] grumpy, int X) {
        int totalCustomer = 0; // sum of all customers;
        int totalGrumpy = 0; // sum of all unsatisfied customers without using technique;
        int save = 0; // currently how many customers change to be happy if using technique, sliding window;
        int maxSave = 0;

        for (int i = 0; i < customers.length; i++) {
            totalCustomer += customers[i];
            totalGrumpy += customers[i] * grumpy[i];
            save += customers[i] * grumpy[i];
            if (i >= X) {
                save -= customers[i - X] * grumpy[i - X];
            }
            maxSave = Math.max(save, maxSave);
        }
        return totalCustomer - totalGrumpy + maxSave;
    }
}