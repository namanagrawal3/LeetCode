class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n-1;
        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }
        
        if (i >= 0) {
            digits[i]++;
            return digits;
        }
        
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }
}