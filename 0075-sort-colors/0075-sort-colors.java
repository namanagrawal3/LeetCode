class Solution {
    public void sortColors(int[] nums) {
        // "Dutch National Flag" algorithm

        int mid = 0;
        int low = 0;
        int high = nums.length;

        while (mid < high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if (nums[mid] == 1)
                mid++;
            else {
                int temp = nums[high-1];
                nums[high-1] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
        return;
    }
}