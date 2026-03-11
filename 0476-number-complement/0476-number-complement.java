class Solution {
    public int findComplement(int n) {
        // Simply convert while finding binary to decimal
         
        int ans = 0;
        int mul = 1;

        while (n > 0) {
            int rem = n % 2;
            ans += mul * (1-rem);
            mul *= 2;
            n /= 2;
        }

        return ans;
    }
}