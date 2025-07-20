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

        int[] dp = new int[n];          // 'dp[i]' denotes the max-score upto index 'i'
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i].score;
        }

        int maxScore = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j].score <= arr[i].score)
                    dp[i] = Math.max(dp[i], dp[j]+arr[i].score);

                maxScore = Math.max(maxScore, dp[i]);
            }
        }

        return maxScore;   
    }
}