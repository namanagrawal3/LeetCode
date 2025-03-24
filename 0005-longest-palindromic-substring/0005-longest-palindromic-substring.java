class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int si = -1;

        // odd-length substring
        for (int axis = 0; axis < n; axis++) {
            for (int orbit = 0; axis-orbit >= 0 && axis+orbit < n; orbit++) {
                if (s.charAt(axis-orbit) != s.charAt(axis+orbit))
                    break;
                
                int len = 2*orbit + 1;
                if (len > maxLen) {
                    maxLen = len;
                    si = axis-orbit;
                }                
            }
        }

        // even-length substring
        for (double axis = 0.5; axis < n; axis++) {
            for (double orbit = 0.5; axis-orbit >= 0 && axis+orbit < n; orbit++) {
                if (s.charAt((int)(axis-orbit)) != s.charAt((int)(axis+orbit)))
                    break;

                int len = (int)(2*orbit + 1);
                if (len > maxLen) {
                    maxLen = len;
                    si = (int)(axis-orbit);
                }
            }
        }

        return s.substring(si, si+maxLen);
    }
}