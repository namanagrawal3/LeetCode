class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        // can also be done using pre & suf concept
        
        int[] ans = new int[n+1];
        int ones = 0, zeros = 0;

        for (int num : nums) {
            if (num == 1)
                ones++;
        }

        for (int i = 0; i < n; i++) {
            ans[i] = zeros + ones;
            if (nums[i] == 0)
                zeros++;
            if (nums[i] == 1)
                ones--;
        }
        ans[n] = zeros;

        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (ans[i] > max)
                max = ans[i];
        }

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (ans[i] == max)
                l.add(i);
        }

        return l;
    }
}