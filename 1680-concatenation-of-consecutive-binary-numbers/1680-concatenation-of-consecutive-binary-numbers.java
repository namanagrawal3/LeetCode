class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long mul = 1;
        long ans = 0;

        for (int i = n; i >= 1; i--) {
            int num = i;
            while (num > 0) {
                int rem = num % 2;
                ans += mul * rem;
                ans %= mod;
                mul *= 2;
                mul %= mod;
                num /= 2;
            }
        }

        return (int) ans;
    }
}