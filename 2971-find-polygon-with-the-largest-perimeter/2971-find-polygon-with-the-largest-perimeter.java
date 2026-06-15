class Solution {
    public long largestPerimeter(int[] nums) {
    // Similar to 'Valid Triangle Number', just need to check the sums of smaller sides to check a valid polygon
     
        int n = nums.length;
        Arrays.sort(nums);

        long sum = 0;
        long perimeter = 0;

        for (int i = 0; i < n-1; i++) {
            sum += nums[i];
            if (sum > nums[i+1])
                perimeter = sum + nums[i+1];
        }

        return (perimeter == 0) ? -1 : perimeter;
    }
}