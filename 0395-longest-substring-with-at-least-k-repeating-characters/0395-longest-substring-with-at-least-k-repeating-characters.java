class Solution {
    public int longestSubstring(String s, int k) {
        if (k == 1)
            return s.length();
        
        int n = s.length();
        int uniqueCnt = 0;
        int[] fre = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if (fre[idx] == 0)
                uniqueCnt++;
            fre[idx]++;
        }

        int maxLen = 0;
        for (int cnt = 1; cnt <= uniqueCnt; cnt++) {
            HashMap<Character, Integer> map = new HashMap<>();

            int si = 0, ei = 0;
            while (ei < n) {
                char ch = s.charAt(ei);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                while (map.size() > cnt && si <= ei) {
                    char ch2 = s.charAt(si);
                    map.put(ch2, map.get(ch2) - 1);
                    if (map.get(ch2) == 0)
                        map.remove(ch2);
                    si++;
                }

                if (checkFun(map, k))
                    maxLen = Math.max(maxLen, ei-si+1);
                ei++;
            }
        }
        
        return maxLen;
    }
    public boolean checkFun(HashMap<Character, Integer> map, int k) {
        for (int val : map.values()) {
            if (val < k)
                return false;
        }
        return true;
    }
}