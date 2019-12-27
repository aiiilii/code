public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) { // eg. 3,4,5,6,1,2
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // (nums[left] > nums[mid]) eg. 5,6,1,2,3,4
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                right = mid - 1;
                }
            }
        }
        return -1;
    }
}