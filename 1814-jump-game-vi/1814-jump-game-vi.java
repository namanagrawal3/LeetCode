class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;        
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> dq = new ArrayDeque<>();       // max in window size k
        dq.addFirst(0);

        for (int i = 1; i < n; i++) {
            if (dq.getFirst() < i-k)
                dq.removeFirst();
            dp[i] = nums[i] + dp[dq.getFirst()];

            while (!dq.isEmpty() && dp[i] > dp[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        return dp[n-1];
    }
}