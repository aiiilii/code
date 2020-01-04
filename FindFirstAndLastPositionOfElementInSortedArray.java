public class FindFirstAndLastPositionOfElementInSortedArray {

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