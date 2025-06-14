class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0, maxFre = 0;
        int si = 0, ei = 0;

        while (ei < n) {
            char ch = s.charAt(ei);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFre = Math.max(maxFre, map.get(ch));

            while ((ei-si+1) - maxFre > k && si <= ei) {
                char sch = s.charAt(si);
                map.put(sch, map.get(sch) - 1);
                if (map.get(sch) == 0)
                    map.remove(sch);
                si++;
                maxFre = maxFreFun(map);
            }

            maxLen = Math.max(maxLen, ei-si+1);
            ei++;
        }

        return maxLen;
    }
    public int maxFreFun(HashMap<Character, Integer> map) {
        int max = 0;
        for (char ch: map.keySet()) {
            max = Math.max(max, map.get(ch));
        }
        return max;
    }
}