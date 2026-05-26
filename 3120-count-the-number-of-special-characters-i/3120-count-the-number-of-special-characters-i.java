class Solution {
    public int numberOfSpecialChars(String word) {
        int[] fre1 = new int[26];       // for the small letters
        int[] fre2 = new int[26];       // for the capital letters
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch >= 65 && ch <= 90)
                fre2[ch-'A']++;
            else 
                fre1[ch-'a']++;
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (fre1[i] > 0 && fre2[i] > 0)
                cnt++;
        }

        return cnt;
    }
}