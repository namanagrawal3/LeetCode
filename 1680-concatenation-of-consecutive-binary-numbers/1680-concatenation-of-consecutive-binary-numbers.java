class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int bits = 0;                 
        int mod = 1000000007;

        for (int i = 1; i <= n; i++) {
            if ((i & (i-1)) == 0)           // power of 2
                bits++;
            ans = (((ans << bits) % mod) + i) % mod;
        }

        return (int) ans;
    }
}