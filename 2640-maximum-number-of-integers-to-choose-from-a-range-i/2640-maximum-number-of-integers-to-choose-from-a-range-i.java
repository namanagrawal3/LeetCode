class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int b : banned) {
            set.add(b);
        }

        int currSum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i))
                continue;
            
            if (currSum + i <= maxSum) {
                cnt++;
                currSum += i;
            }
        }

        return cnt;
    }
}