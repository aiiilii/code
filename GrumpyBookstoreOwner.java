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
            save += customers[i] * grumpy[i]; // save comes from grumpies, does not record the satisfied customers;
            if (i >= X) {
                save -= customers[i - X] * grumpy[i - X]; // sliding window, i - X is the previous one
            }
            maxSave = Math.max(save, maxSave); // thus, maxSave does not include the satisfied customers either, 
        }
        return totalCustomer - totalGrumpy + maxSave; // so when added at the end, do not need to subtract the satisfied customers (not added twice, only added once);
    }
}