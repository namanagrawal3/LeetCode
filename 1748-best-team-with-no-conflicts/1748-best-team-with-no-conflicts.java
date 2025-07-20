class Solution {
    class Player {
        int score;
        int age;
        public Player(int s, int a) {
            score = s;
            age = a;
        }
    }
    public int bestTeamScore(int[] scores, int[] ages) {
    // Similar to 'Russian Doll Envelopes' (Sorting & max-score using DP)

        int n = scores.length;
        Player[] arr = new Player[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Player(scores[i], ages[i]);
        }

        Arrays.sort(arr, new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                if (a.age == b.age)
                    return a.score - b.score;
                return a.age - b.age;
            }
        });

        int[][] dp = new int[n][n];
        return maxFun(arr, 0, -1, dp);
    }
    public int maxFun(Player[] arr, int idx, int prev, int[][] dp) {
        if (idx == arr.length)
            return 0;

        if (dp[idx][prev+1] != 0)
            return dp[idx][prev+1];

        int take = 0, not_take = 0;
        if (prev == -1 || arr[idx].score >= arr[prev].score)
            take = arr[idx].score + maxFun(arr, idx+1, idx, dp);
        not_take = maxFun(arr, idx+1, prev, dp);

        return dp[idx][prev+1] = Math.max(take, not_take);
    }
}