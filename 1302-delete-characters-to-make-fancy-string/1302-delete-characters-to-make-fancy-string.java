class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        int i = 0, j = 0;
        while (j < n) {
            while (j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }

            for (int k = 0; k < Math.min(j-i, 2); k++) {
                ans.append(s.charAt(i));
            }

            i = j;
        }
        
        return ans.toString();
    }
}