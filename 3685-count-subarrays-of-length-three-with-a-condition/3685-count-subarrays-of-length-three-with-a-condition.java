class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        int si = 0, ei = 2;
        while (ei < n) {
            if (nums[si] + nums[ei] == nums[si+1]/2.0)
                cnt++;
            
            ei++;
            si++;
        } 

        return cnt;
    }
}