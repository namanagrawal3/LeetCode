class Solution {
    public long validSubstringCount(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

       if (l2 > l1)
           return 0;

        int[] fre2 = new int[26];
        for (int i = 0; i < l2; i++) {
            char ch = word2.charAt(i);
            fre2[ch - 'a']++;
        }

        int[] freCurr = new int[26];
        long count = 0;
        int si = 0, ei = 0;
        while (ei < l1) {
            char ch = word1.charAt(ei);
            freCurr[ch - 'a']++;

            while (checkFun(freCurr, fre2)) {
                count += l1-ei;
                freCurr[word1.charAt(si) - 'a']--;
                si++;
            }

            ei++;
        }

        return count;
    }
    public static boolean checkFun(int[] fre1, int[] fre2) {
        for (int i = 0; i < 26; i++) {
            if (fre1[i] < fre2[i])
                return false;
        }
        return true;
    }
}