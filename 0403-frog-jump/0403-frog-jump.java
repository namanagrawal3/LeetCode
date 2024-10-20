class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;

        int n = stones.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        int[][] dp = new int[n][n];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return solveFun(stones, n, 1, 1, map, dp);
    }
    public boolean solveFun(int[] stones, int n, int idx, int prevJump, HashMap<Integer, Integer> map, int[][] dp) {
        if (idx == n-1)
            return true;

        if (idx >= n)
            return false;

        if (dp[idx][prevJump] != -1)
            return (dp[idx][prevJump] == 0) ? false : true;

        boolean ans = false;
        int[] j = {-1, 0, 1};
        for (int i = 0; i < 3; i++) {
            int jump = prevJump + j[i];
                        
            if (jump > 0 && map.containsKey(stones[idx]+jump)) {
                ans = solveFun(stones, n, map.get(stones[idx]+jump), jump, map, dp);
                if (ans)
                    return true;
            }
        }

        dp[idx][prevJump] = 0;
        return false;
    }
}