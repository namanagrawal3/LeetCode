class Solution {
    int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n - even;

        return (int)(pow(5, even)%mod * pow(4, odd)%mod) % mod;
    }
    public long pow(long a, long n) {
        if (n == 0)
            return 1;

        long ans = pow(a, n/2) % mod;
        ans = (ans * ans) % mod;
        if (n % 2 != 0)
            ans = (ans * a) % mod;

        return ans % mod;
    }
}