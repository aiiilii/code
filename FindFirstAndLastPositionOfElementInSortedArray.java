public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 2 binary searches
     * Time - O(logn)
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }
    private static int findLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) { // cannot be low <= high because no return to break the inifite loop if high = mid = low
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid; // move high to where mid is and keep searching until find the leftmost number that == target
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (nums[low] == target) {
            return low;
        }
        return -1;
    }
    private static int findRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2; //+1 because need the ceiling number for mid to avoid infinite loop
            if (nums[mid] == target) {
                low = mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (nums[high] == target) {
            return high;
        }
        return -1;
    }
    

    /**
     * 1 binary search and 2 while loops
     * Time - O(log n) + O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int mid = findMid(nums, target);

        if (mid == -1) {
            return res;
        }
        
        int i = -1;
        int j = -1;
        if (mid != -1) {
            i = mid;
            j = mid;
            while (i >= 0 && nums[i] == target) {
                i--;
            }
            while (j < nums.length && nums[j] == target) {
                j++;
            }
        }
        int low = i + 1;
        int high = j - 1;
        
        res[0] = low;
        res[1] = high;
        
        return res;
    }

    private static int findMid(int[] nums, int target) {
        int mid = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int m = left + (right - left) / 2;
            if (nums[m] == target) {
                mid = m;
                break;
            } else if (nums[m] > target) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        System.out.println(searchRange(nums, 1));
    }
}