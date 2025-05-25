class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = 0;

        for (String word: words) {
            String rev = word.charAt(1) + "" + word.charAt(0);
            if (map.containsKey(rev) && map.get(rev) > 0) {
                len += 4;
                map.put(rev, map.get(rev)-1);
            } 
            else 
                map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word: map.keySet()) {
            if (word.charAt(0) == word.charAt(1) && map.get(word) > 0) {
                len += 2;
                break;
            }
        }

        return len;
    }
}