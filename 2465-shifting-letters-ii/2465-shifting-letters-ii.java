class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n+1];          // difference array
        for (int[] shift : shifts) {
            int l = shift[0];
            int r = shift[1];
            if (shift[2] == 0) {
                diff[l]--;
                diff[r+1]++;
            }
            else {
                diff[l]++;
                diff[r+1]--;
            }
        }

        for (int i = 1; i < n; i++) {       // calculating cumulative sum
            diff[i] = diff[i] + diff[i-1];
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i)-'a';
            int shift = diff[i] % 26;
            if (shift < 0)
                shift += 26;

            ch = (ch + shift) % 26;
            ans.append((char)(ch+'a'));
        }

        return ans.toString();
    }
}