class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int maxIdx = 0;
        int wins = 0;

        for (int i = 1; i < n; i++) {
            if (skills[maxIdx] > skills[i]) 
                wins++;
            else {
                maxIdx = i;
                wins = 1;
            }

            if (wins == k)
                return maxIdx;
        }

        return maxIdx;
    }
}