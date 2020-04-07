import java.util.TreeMap;

public class RelativeSortArray {

    /**
     * Counting sort approach
     * Because 0 <= arr1[i], arr2[i] <= 1000, we use an array to count every element.
     * Go through every element in the second array, and update values of the first array based on the order in the second array.
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



    /**
     * TreeMap approach
     * If contraint 0 <= arr1[i], arr2[i] <= 1000 does not exist.
     * Time - O(n log n)
     * Space - O(n)
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int i = 0;
        for (int n : arr2) {
            while (map.get(n) > 0) {
                arr1[i] = n;
                i ++;
                map.put(n, map.get(n) - 1);
            }
        }

        for (int n : map.keySet()) {
            while (map.get(n) > 0) {
                arr1[i] = n;
                i ++;
                map.put(n, map.get(n) - 1);
            }
        }
        return arr1;
    }
}