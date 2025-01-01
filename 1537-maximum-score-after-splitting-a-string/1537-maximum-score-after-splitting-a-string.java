class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int c1 = 0, c0 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                c1++;
        }

        int maxScore = 0;
        for (int i = 0; i < n-1; i++) {
            char ch = s.charAt(i);
            if (ch == '0')
                c0++;
            else
                c1--;
            
            maxScore = Math.max(maxScore, c0+c1);
        }

        return maxScore;
    }
}