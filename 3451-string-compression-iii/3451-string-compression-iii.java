class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int n = word.length();
        
        int i = 0;
        while (i < n) {
            char ch = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == ch) {
                i++;
                count++;
            }

            int rem = count % 9;
            int times = count / 9;
            for (int j = 0; j < times; j++) {
                ans.append(9);
                ans.append(ch);
            }
            if (rem != 0) {
                ans.append(rem);
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}