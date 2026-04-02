class Solution {
    public String smallestPalindrome(String s) {
    // Simply make the first-half string lexical small and reverse it for second half
        int n = s.length();
        int midIdx = n/2;

        // Stroring the freq of first half
        int[] fre = new int[26];                 
        for (int i = 0; i < midIdx; i++) {
            char ch = s.charAt(i);
            fre[ch-'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < fre[i]; j++) {
                ans.append((char)('a'+i));
            }
        }

        if (n % 2 == 0)
            return ans.toString() + ans.reverse().toString();
        return ans.toString() + s.charAt(midIdx) + ans.reverse().toString();
    }
}