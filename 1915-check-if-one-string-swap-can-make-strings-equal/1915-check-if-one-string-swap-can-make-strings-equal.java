class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int pos = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                pos++;            
            if (pos > 2)
                return false;
        }

        int[] fre = new int[26];
        for (int i = 0; i < n; i++) {
            fre[s1.charAt(i)-'a']++;
            fre[s2.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (fre[i] != 0)
                return false;
        }

        return true;
    }
}