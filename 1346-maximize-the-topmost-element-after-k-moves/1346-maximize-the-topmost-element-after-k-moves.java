class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (k == 0)
            return nums[0];  

        if (n == 1) {
            if (k % 2 == 0)
                return nums[0];
            return -1;
        }

        if (k == 1)
            return nums[1];

        int maxVal = -1;
        if (k == n) 
            maxVal = maxFun(nums, n-2);
        else if (k < n) 
            maxVal = Math.max(nums[k], maxFun(nums, k-2));
        else 
            maxVal = maxFun(nums, n-1);

        return maxVal;
    }
    public int maxFun(int[] arr, int ei) {
        int max = arr[0];
        for (int i = 1; i <= ei; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}