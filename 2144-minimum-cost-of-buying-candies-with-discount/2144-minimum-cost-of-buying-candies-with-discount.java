class Solution {
    public int minimumCost(int[] cost) {
    // Simply buy the costliest 2 candies and get the third costly candy free

        int n = cost.length;
        Arrays.sort(cost);
        int minCost = 0;

        int i = n-1;
        for (; i > 0; i -= 3) {
            minCost += cost[i];
            minCost += cost[i-1];
        }

        if (i == 0)
            minCost += cost[0];
            
        return minCost;
    }
}