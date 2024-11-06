class Solution {
    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        int[] fre = new int[5];
        int uniqueVow = 0;
        int maxLen = 0;

        int si = 0, ei = 0;
        while (ei < n) {
            char ch = word.charAt(ei);
            int idx = vowIdx(ch);
            if (fre[idx] == 0)
                uniqueVow++;
            fre[idx]++;

            if (!checkFun(fre, idx)) {
                si = ei;
                for (int i = 0; i < 5; i++) {
                    if (i == idx)
                        fre[i] = 1;
                    else
                        fre[i] = 0;
                }
                uniqueVow = 1;
            }

            if (uniqueVow == 5)
                maxLen = Math.max(maxLen, ei-si+1);

            ei++;
        }

        return maxLen;
    }
    public boolean checkFun(int[] fre, int idx) {
        for (int i = idx+1; i < 5; i++) {
            if (fre[i] != 0)
                return false;
        }
        for (int i = 0; i < idx; i++) {
            if (fre[i] == 0)
                return false;
        }
        return true;
    }
    public int vowIdx(char ch) {
        if (ch == 'a')
            return 0;
        else if (ch == 'e')
            return 1;
        else if (ch == 'i')
            return 2;
        else if (ch == 'o')
            return 3;
        else
            return 4;
    }
}