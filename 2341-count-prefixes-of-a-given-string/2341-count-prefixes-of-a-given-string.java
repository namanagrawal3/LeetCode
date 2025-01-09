class Solution {
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;

        for (String word : words) {
            if (s.indexOf(word) == 0)
                cnt++;
        }

        return cnt;
    }
}