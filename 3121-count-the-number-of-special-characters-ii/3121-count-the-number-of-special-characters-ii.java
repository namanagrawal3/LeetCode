class Solution {
    public int numberOfSpecialChars(String word) {
        int[] idx1 = new int[26];       // stores the last index of small letter
        int[] idx2 = new int[26];       // stores the first index of capital letter
        int n = word.length();

        Arrays.fill(idx1, -1);
        Arrays.fill(idx2, -1);

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch >= 97 && ch <= 122) {
                idx1[ch-'a'] = i;
            }
            else {
                if (idx2[ch-'A'] == -1)
                    idx2[ch-'A'] = i;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (idx1[i] != -1 && idx2[i] != -1 && idx1[i] < idx2[i])
                cnt++;
        }

        return cnt;
    }
}