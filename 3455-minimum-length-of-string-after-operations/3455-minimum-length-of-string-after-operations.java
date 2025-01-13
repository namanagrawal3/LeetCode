class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int[] fre = new int[26];
        for (int i = 0; i < n; i++) {
            fre[s.charAt(i)-'a']++;
        }

        int len = 0;
        for (int i = 0; i < 26; i++) {
            if (fre[i] == 0)
                continue;
            if (fre[i] % 2 == 0)
                len += 2;
            else
                len += 1;
        }

        return len;
    }
}