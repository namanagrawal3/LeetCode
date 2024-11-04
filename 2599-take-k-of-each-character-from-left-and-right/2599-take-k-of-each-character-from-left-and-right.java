class Solution {
    public int takeCharacters(String s, int k) {
        // find the longest subarray which does not contain the required number of char
        int n = s.length();
        int[] fre = new int[3];     // {a,b,c}

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            fre[ch-'a']++;
        }
        for (int i = 0; i < 3; i++) {
            fre[i] -= k;
            if (fre[i] < 0)
                return -1;
        }

        int[] curr = new int[3];
        int si = 0, ei = 0;
        int maxLen = 0;
        while (ei < n) {
            char ch = s.charAt(ei);
            curr[ch-'a']++;

            while (curr[ch-'a'] > fre[ch-'a'] && si <= ei) {
                char sch = s.charAt(si);
                curr[sch-'a']--;
                si++;
            }

            maxLen = Math.max(maxLen, ei-si+1);
            ei++;
        }

        return n-maxLen;
    }
}