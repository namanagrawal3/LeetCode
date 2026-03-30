class Solution {
    public boolean checkStrings(String s1, String s2) {
    // We can swap among any even index chars (similarly, among odd index chars)
    // Thus, check frequency must be equal of odd & even index chars respectively (in s1 & s2)
        int n = s1.length();
        int[] oddFreq = new int[26];
        int[] evenFreq = new int[26];

        for (int i = 0; i < n; i += 2) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            evenFreq[c1]++;
            evenFreq[c2]--;
        }

        for (int i = 1; i < n; i += 2) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            oddFreq[c1]++;
            oddFreq[c2]--;
        }

        for (int i = 0; i < 26; i++) {
            if (oddFreq[i] != 0 || evenFreq[i] != 0)
                return false;
        }

        return true;
    }
}