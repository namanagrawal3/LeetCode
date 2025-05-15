class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> l = new ArrayList<>();
        int n = words.length;

        l.add(words[0]);
        int bit = groups[0];

        for (int i = 1; i < n; i++) {
            if (groups[i] == 1-bit) {
                bit = 1-bit;
                l.add(words[i]);
            }
        }

        return l;
    }
}