class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < n-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            if (w1.length() != w2.length() && w1.startsWith(w2))
                return false;

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 == ch2)
                    continue;

                if (map.get(ch1) > map.get(ch2))
                    return false;
                break;
            }
        }
        
        return true;
    }
}