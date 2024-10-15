class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int opr = 0;
        int left = 0;
        int right = n-1;                        // similar to '2-Sum' problem
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == k) {
                opr++;
                left++;
                right--;
            }
            else if (sum < k)
                left++;
            else
                right--;
        }

        return opr;
    }
}