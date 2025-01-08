class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (check(words[i], words[j]))
                    count++;
            }
        }

        return count;
    }
    public boolean check(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if (m > n)
            return false;

        for (int i = 0; i < m; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                return false;
        }

        for (int i = n-m; i < n; i++) {
            if (str1.charAt(i-n+m) != str2.charAt(i))
                return false;
        }
        return true;
    }
}