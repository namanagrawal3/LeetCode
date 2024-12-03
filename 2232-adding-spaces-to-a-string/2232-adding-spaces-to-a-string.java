class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();             // spaces are given in increasing order

        int i = 0, j = 0;
        while (j < spaces.length) {
            if (i == spaces[j]) {
                ans.append(" ");
                j++;
            }
            ans.append(s.charAt(i));
            i++;
        }
        while (i < n) {
            ans.append(s.charAt(i));
            i++;
        }
        
        return ans.toString();
    }
}