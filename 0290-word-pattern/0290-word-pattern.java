class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();
        if (n != words.length)
            return false;
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (set.contains(words[i]))
                    return false;
                
                map.put(ch, words[i]);
                set.add(words[i]);
            }
            else {
                if (!map.get(ch).equals(words[i]))
                    return false;
            }
        }
        
        return true;
    }
}