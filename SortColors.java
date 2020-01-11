public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int firstColor = 0;
        while (firstColor < nums.length && nums[firstColor] == 0) {
            firstColor++;
        }
        int lastColor = nums.length - 1;
        while (lastColor >= 0 && nums[lastColor] == 2) {
            lastColor--;
        }

        // start from first non-0 number
        int index = firstColor;
        while (index <= lastColor) {
            if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 0) {
                switchColor(nums, firstColor, index);
                firstColor++;
                index++;
            } else if (nums[index] == 2) {
                switchColor(nums, lastColor, index);
                lastColor--;
            }
        }
    }

    private void switchColor(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}