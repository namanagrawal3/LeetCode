class Solution {
    public int maximumLengthSubstring(String s) {
    // Simply, use the 'Sliding Window' technique
    
        int n = s.length();
        int[] freq = new int[26]; 
        int maxLen = 0;

        int si = 0, ei = 0;
        while (ei < n) {
            char ch = s.charAt(ei);
            freq[ch-'a']++;

            while (si <= ei && freq[ch-'a'] > 2) {
                freq[s.charAt(si)-'a']--;
                si++;
            }

            maxLen = Math.max(maxLen, ei-si+1);
            ei++;
        }

        return maxLen;
    }
}