//import java.util.Arrays;

public class LongestIncresingSubsequence {

    /**
     * DP with Binary Search approach
     * Time - O(n log n)
     * Space - O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = binarySearch(dp, 0, len, num); // if not found, will return a negative number of where the insertion should be,
            if (i < 0) {
                i = -(i + 1); // convert that negative number back to the actual insertion index
            }
            dp[i] = num; // insert or add that number into the dp array,
            if (i == len) {
                len ++; // if a number is added, then i == len, because i the most could == (len - 1);
            }
        }
        return len;
    }

    private static int binarySearch(int[] arr, int s, int e, int target) {
        int start = s;
        int end = e - 1; // e is exclusive of the ending index thus need to -1 in order to get the actual last index.
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return - start - 1; // if not found, will provide an index that is (-(insertion index) - 1);
    }

    /**
     * DP with Binary Search approach
     * Time - O(n log n)
     * Space - O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            int index = findNearOne(dp, 1, res, nums[i]);
            if (index == res) {
                res ++;
                dp[res] = nums[i];
            } else {
                dp[index + 1] = nums[i];
            }
        }
        return res;
    }

    private int findNearOne(int[] dp, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (dp[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * DP approach
     * Time - O(n ^ 2)
     * Space - O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}