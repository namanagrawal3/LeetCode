class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int n = s.length();
        int[] fre = new int[26];

        for (int i = 0; i < n; i++) {       // iterating over string s
            fre[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < n; i++) {       // iterating over string t
            fre[t.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++) {      
            if (fre[i] != 0)
                return false;
        }
        return true;
    }
}