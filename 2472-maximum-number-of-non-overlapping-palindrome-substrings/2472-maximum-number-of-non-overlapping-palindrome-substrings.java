class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;

        int count = 0;
        for (int i = 0; i <= n - k; i++) {
            if (isPalindrome(s, i, i + k - 1)) {
                count++;
                i += k - 1;
            } 
            else if (i < n - k && isPalindrome(s, i, i + k)) {
                count++;
                i += k;
            }
        }

        return count;
    }
    public boolean isPalindrome(String s, int l, int r) {
        for (; l < r; l++, r--)
            if (s.charAt(l) != s.charAt(r))
                return false;
        return true;
    }
}