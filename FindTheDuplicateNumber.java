public class FindTheDuplicateNumber {

    /**
     * Using the array like a linkedlist
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow]; // slow goes 1 step
            fast = nums[nums[fast]]; // fast goes 2 steps
        } while (slow != fast);

        int pointer1 = nums[0];
        int pointer2 = slow;

        while (pointer1 != pointer2) {
            pointer1 = nums[pointer1];
            pointer2 = nums[pointer2];
        }

        return pointer1;
    }
}