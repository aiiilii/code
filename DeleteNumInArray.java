public class DeleteNumInArray {

    public static void deleteNum(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            while (nums[j] == -1) {
                j ++;
            }
            nums[i] = nums[j];
            i ++;
            j ++;
        }
        while (i < nums.length) {
            nums[i] = -1;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 2, 1, 3, -1, 4, 2};
        deleteNum(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}