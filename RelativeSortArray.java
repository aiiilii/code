public class RelativeSortArray {

    /**
     * Time - O(n)
     * Space - O(1)
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int n : arr1) {
            count[n] ++;
        }

        int i = 0;
        for (int n : arr2) {
            while (count[n] > 0) {
                count[n] --;
                arr1[i] = n;
                i ++; 
            }
        }

        for (int n = 0; n < count.length; n++) {
            while (count[n] > 0) {
                count[n] --;
                arr1[i] = n;
                i ++;
            }
        }

        return arr1;
    }
}