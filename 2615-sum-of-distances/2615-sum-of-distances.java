class Solution {
    public long[] distance(int[] nums) {
    // Simply use the concept of 'Prefix' (Derive the pattern)

        int n = nums.length;
        long[] ans = new long[n];
        HashMap<Integer, Long> idxSum = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Handling the left side identical elements
        for (int i = 0; i < n; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 0);
                idxSum.put(nums[i], 0L);
            }

            ans[i] = (1L * freq.get(nums[i]) * i) - idxSum.get(nums[i]);
            freq.put(nums[i], freq.get(nums[i]) + 1);
            idxSum.put(nums[i], idxSum.get(nums[i]) + i);
        }

        freq.clear();
        idxSum.clear();

        // Handling the right side identical elements
        for (int i = n-1; i >= 0; i--) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 0);
                idxSum.put(nums[i], 0L);
            }

            ans[i] += idxSum.get(nums[i]) - (1L * freq.get(nums[i]) * i);
            freq.put(nums[i], freq.get(nums[i]) + 1);
            idxSum.put(nums[i], idxSum.get(nums[i]) + i);
        }

        return ans;
    }
}