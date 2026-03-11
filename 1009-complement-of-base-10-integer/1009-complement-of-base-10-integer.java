class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;
            
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