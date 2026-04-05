class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int pow = 1;
        while (num > 0) {
            int rem = num % 2;
            num /= 2;
            ans += (1-rem) * pow;
            pow *= 2;
        }
        return ans;
    }
}