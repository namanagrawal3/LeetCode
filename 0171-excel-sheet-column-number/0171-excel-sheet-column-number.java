class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int mul = 1;

        for (int i = s.length()-1; i >= 0; i--) {
            int val = s.charAt(i) - 64;
            ans += mul*val;
            mul = mul*26;
        }

        return ans;
    }
}