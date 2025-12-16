class Solution {
    public int specialTriplets(int[] nums) {
    // For each index (j), we will count the freq on both left & right side 
        int n = nums.length;
        HashMap<Integer, Integer> suff = new HashMap<>();
        for (int i = 0; i < n; i++) {
            suff.put(nums[i], suff.getOrDefault(nums[i], 0) + 1);
        }

        HashMap<Integer, Integer> pref = new HashMap<>();
        int mod = 1000000007;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            suff.put(nums[i], suff.get(nums[i]) - 1);

            int left = pref.containsKey(nums[i] * 2) ? pref.get(nums[i] * 2) : 0;
            int right = suff.containsKey(nums[i] * 2) ? suff.get(nums[i] * 2) : 0;
            cnt += (1L * left * right) % mod;
            cnt %= mod;

            pref.put(nums[i], pref.getOrDefault(nums[i], 0) + 1);
        }

        return cnt;
    }
}