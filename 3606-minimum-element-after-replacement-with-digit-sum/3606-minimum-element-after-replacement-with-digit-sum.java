class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int min = sumFun(nums[0]);

        for (int num : nums) {
            int sum = sumFun(num);
            if (sum < min)
                min = sum;
        }

        return min;
    }
    public int sumFun(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}