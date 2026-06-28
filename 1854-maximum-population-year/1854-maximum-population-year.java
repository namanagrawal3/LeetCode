class Solution {
    public int maximumPopulation(int[][] logs) {
    // Simply, apply the 'Differnce Array' technique.
    // Since, it is range based problem 'Line Sweep' technique can also be used
        
        int[] diff = new int[101];

        for (int[] log: logs) {
            int birth = log[0] - 1950;              // '1950' made as 0-based index
            int death = log[1] - 1950;
            diff[birth]++;
            diff[death]--;
        }

        int maxPopYear = 0;
        int maxPop = diff[0];

        for (int i = 1; i < 101; i++) {
            diff[i] += diff[i-1];
            if (diff[i] > maxPop) {
                maxPop = diff[i];
                maxPopYear = i;
            }
        }

        return maxPopYear + 1950;
    }
}