class Solution {
    public int countPermutations(int[] complexity) {
    // If more than 1 min element exits then '0', otherwise '(n-1)!'
        int n = complexity.length;
        int mod = 1000000007;

        int min = complexity[0];
        int cnt = 1;
        long ans = 1;

        for (int i = 1; i < n; i++) {
            if (complexity[i] < min) {
                min = complexity[i];
                cnt = 1;
            }
            else if (complexity[i] == min)
                cnt++;

            ans = (ans * i) % mod;
        }

        if (cnt > 1 || complexity[0] != min)
            return 0;
        return (int)ans;
    }
}