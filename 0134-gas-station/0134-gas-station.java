class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSum = 0;
        int currSum = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            totalSum += gas[i] - cost[i];
            currSum += gas[i] - cost[i];
            if (currSum < 0) {
                ans = i+1;
                currSum = 0;
            }
        }

        if (ans == n || totalSum < 0)
            return -1;
        return ans;
    }
}