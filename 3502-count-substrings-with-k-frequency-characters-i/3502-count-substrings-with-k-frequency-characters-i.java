class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int[] fre = new int[26];
        int count = 0;

        int si = 0, ei = 0;
        while (ei < n) {
            char ch = s.charAt(ei);
            fre[ch-'a']++;

            while (fre[ch-'a'] == k) {
                count += n-ei;            
                fre[s.charAt(si)-'a']--;
                si++;
            }

            ei++;
        }
        
        return count;
    }
}