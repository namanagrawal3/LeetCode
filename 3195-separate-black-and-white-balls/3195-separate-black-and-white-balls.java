class Solution {
    public long minimumSteps(String s) {
        int pos = 0;
        int n = s.length();
        long swaps = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                swaps += i-pos;
                pos++;
            }
        }

        return swaps;
    }
}