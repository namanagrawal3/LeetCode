class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int n = s.length();
        if (k > n)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        int[] fre_p = new int[26];
        int[] fre_s = new int[26];

        for (int i = 0; i < k; i++) {
            int idx = p.charAt(i) - 'a';
            fre_p[idx]++;
        }

        int si = 0, ei = 0;
        for (; ei < k; ei++) {
            char ch = s.charAt(ei);
            fre_s[ch - 'a']++;
        }
        if (checkEqual(fre_s, fre_p))
            ans.add(si);

        while (ei < n) {
            char ch = s.charAt(ei);
            fre_s[ch - 'a']++;

            char ch2 = s.charAt(si);
            fre_s[ch2 - 'a']--;
            si++;

            if (checkEqual(fre_s, fre_p))
                ans.add(si);
            ei++;
        }

        return ans;
    }
    public static boolean checkEqual(int[] fre1, int[] fre2) {
        for (int i = 0; i < 26; i++) {
            if (fre1[i] != fre2[i])
                return false;
        }
        return true;
    }
}