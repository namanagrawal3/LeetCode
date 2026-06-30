class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
    // We need to keep the max element at the max occuring index, thus need to find the occurence of indices in requests
    // Use the 'Difference Array' technique to count the indices in requests

        int n = nums.length;
        int[] diff = new int[n];

        for (int[] req: requests) {
            int start = req[0];
            int end = req[1];

            diff[start]++;
            if (end+1 < n)
                diff[end+1]--;
        }   

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i-1]; 
        }

        Arrays.sort(diff);
        Arrays.sort(nums);
        
        long mod = 1000000007;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (1L * diff[i] * nums[i]) % mod;
            ans %= mod;
        }

        return (int) ans;
    }
}