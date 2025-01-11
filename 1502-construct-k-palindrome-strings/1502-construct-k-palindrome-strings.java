class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (k > n)
            return false;

        int[] fre = new int[26];
        for (int i = 0; i < n; i++) {
            fre[s.charAt(i)-'a']++;
        }

        int oddFre = 0;
        for (int i = 0; i < 26; i++) {
            if (fre[i] % 2 != 0)
                oddFre++;
        }

        if (oddFre > k)
            return false;
        return true;
    }
}