class Solution {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] last = new int[n];
        Arrays.fill(last, -1);

        int j = n-1;
        for (int i = m-1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
        }

        boolean flip = true;
        int[] ans = new int[n];
        int idx = 0;
        j = 0;

        for (int i = 0; i < m; i++) {
            if (j < n) {
                if ((word1.charAt(i) == word2.charAt(j)) || (flip == true && (j == n-1 || i+1 <= last[j+1]))) {
                    if (word1.charAt(i) != word2.charAt(j))
                        flip = false;

                    ans[idx++] = i;
                    j++;
                }
            }
        }

        return (j == n) ? ans : new int[]{};
    }
}