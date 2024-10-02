class Solution {
    public int expressiveWords(String s, String[] words) {
        int cnt = 0;
        for (String word : words) {
            if (checkFun(word, s))
                cnt++;
        }

        return cnt;
    }
    public static boolean checkFun(String word, String s) {
        if (word.length() > s.length())
            return false;

        if (word.length() == s.length() && !word.equals(s))
            return false;

        int i = 0, j = 0;
        int n = word.length(), m = s.length();
        int cnt1 = 0, cnt2 = 0;
        while (i < n && j < m) {
            char ch1 = word.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 != ch2)
                return false;

            while (i < n && word.charAt(i) == ch1) {
                i++;
                cnt2++;
            }
            while (j < m && s.charAt(j) == ch2) {
                j++;
                cnt1++;
            }

            if (cnt2 > cnt1)
                return false;
            if (cnt1 != cnt2 && cnt1 < 3)
                return false;

            cnt1 = 0;
            cnt2 = 0;
        }

        if ((i == n && j < m) || (i < n && j == m))
            return false;
        return true;
    }
}