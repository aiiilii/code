public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int length = nums.length;
        int[] res = new int[length];

        // cache up the sum from the left;
        // res[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the res[0] would be 1
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // r contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the r would be 1
        int r = 1;
        for (int j = length - 1; j >= 0; j--) {

            // For the index 'i', r would contain the 
            // product of all elements to the right. We update r accordingly
            res[j] = res[j] * r;
            r = r * nums[j];
        }
        return res;
    }
}