class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] idx = new int[n];       // stores the second-last index of element

        for (int i = n-1; i >= 0; i--) {
            int t = -1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] == nums[i]) {
                    t = j;
                    break;
                }
            }
            idx[i] = t;
        }

        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            maxIdx = Math.max(maxIdx, idx[i]);
        }

        if (maxIdx == -1)
            return 0;
            
        maxIdx++;
        return (int) Math.ceil(maxIdx / 3.0);
    }
}