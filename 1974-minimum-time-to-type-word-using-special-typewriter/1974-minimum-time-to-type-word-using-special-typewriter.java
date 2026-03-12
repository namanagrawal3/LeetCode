class Solution {
    public int minTimeToType(String word) {
        int n = word.length();
        int time = 0;
        char curr = 'a';

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            int d1 = Math.abs(ch - curr);
            int d2 = 26 - d1;

            time += Math.min(d1, d2);
            curr = ch;
        }

        return time + n;
    }
}