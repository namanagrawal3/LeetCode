class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int N = queries.length;

        int[] pre = new int[n];
        pre[0] = (isVowel(words[0].charAt(0)) && isVowel(words[0].charAt(words[0].length()-1))) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + ((isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))) ? 1 : 0);
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            int si = queries[i][0];
            int ei = queries[i][1];

            if (si == 0)
                ans[i] = pre[ei];
            else
                ans[i] = pre[ei] - pre[si-1];
        }

        return ans;
    }
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}