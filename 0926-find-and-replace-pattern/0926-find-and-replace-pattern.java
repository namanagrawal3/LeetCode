class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = pattern.length();
        int[] fre = new int[26];
        for (int i = 0; i < n; i++) {
            fre[pattern.charAt(i)-'a']++;
        }
        Arrays.sort(fre);

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() == pattern.length() && freqFun(word, fre) && checkFun(word, pattern))
                ans.add(word);
        }

        return ans;
    }
    public static boolean freqFun(String s, int[] freP) {
        int n = s.length();
        int[] freS = new int[26];
        for (int i = 0; i < n; i++) {
            freS[s.charAt(i)-'a']++;
        }
        Arrays.sort(freS);

        for (int i = 0; i < 26; i++) {
            if (freP[i] != freS[i])
                return false;
        }
        return true;
    }
    public static boolean checkFun(String word, String pattern) {
        HashMap<Character, Character> map = new HashMap<>();
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char chW = word.charAt(i);
            char chP = pattern.charAt(i);
            if (!map.containsKey(chP))
                map.put(chP, chW);
            else if (map.get(chP) != chW)
                return false;
        }

        return true;
    }
}