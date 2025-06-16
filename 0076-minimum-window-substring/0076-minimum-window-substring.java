class Solution {
    public String minWindow(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < l2; i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;
        int si = 0, ei = 0;
        int count = map.size();

        while (ei < l1) {
            char ch = s.charAt(ei);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    count--;
            }

            while (count == 0 && si <= ei) {
                if ((ei-si+1) < minLen) {
                    minLen = ei-si+1;
                    ans = s.substring(si, ei+1);
                }

                char sch = s.charAt(si);
                if (map.containsKey(sch)) {
                    map.put(sch, map.get(sch) + 1);
                    if (map.get(sch) == 1)
                        count++;
                }
                si++;
            }

            ei++;
        }

        return ans;
    }
}