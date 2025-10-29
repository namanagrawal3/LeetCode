class Solution {
    public int smallestNumber(int n) {
        int pow2 = 1;
        while (pow2 <= n) {
            pow2 = pow2 << 1;
        }

        return pow2 - 1;
    }
}