class Solution {
    public boolean isCircularSentence(String s) {
        int n = s.length();
        if (s.charAt(0) != s.charAt(n-1))
            return false;

        for (int i = 1; i < n-1; i++) {
            char ch = s.charAt(i);
            if (ch == ' ' && s.charAt(i-1) != s.charAt(i+1))
                return false;
        }
        
        return true;
    }
}