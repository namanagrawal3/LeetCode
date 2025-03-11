class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();        
        long total = (1L * n * (n+1))/2;  // total possible substrings
        long count = 0;                   // substrings with no occurence of all three characters
        
        int si = 0, ei = 0;
        while (ei < n) {
            char ch = s.charAt(ei);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while (map.size() > 2 && si <= ei) {
                char rv = s.charAt(si);
                map.put(rv, map.get(rv) - 1);
                if (map.get(rv) == 0)
                    map.remove(rv);
                si++;
            }
            
            count += ei-si+1;
            ei++;
        }
        
        return (int)(total - count);
    }
}