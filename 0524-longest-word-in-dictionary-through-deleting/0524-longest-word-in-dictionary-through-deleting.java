class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        String ans = "";

        for (String word : dictionary) {
            if (checkSubSeq(word, s) && word.length() > ans.length())
                ans = word;
        }

        return ans;
    }
    public static boolean checkSubSeq(String s2, String s1) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l2 > l1)
            return false;

        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else
                i++;
        }
        return j == l2;
    }
}