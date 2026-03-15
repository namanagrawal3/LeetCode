class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int mul = 1 << 31;

        while (n > 0) {
            int rem = n % 2;
            ans += mul * rem;
            mul >>= 1;
            n /= 2;
        }

        return Math.abs(ans);       // Since, MSB = 1 denotes -ve number, thus abs() value
    }
}