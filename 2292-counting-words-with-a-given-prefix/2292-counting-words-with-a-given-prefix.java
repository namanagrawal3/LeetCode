class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        
        for (String word : words) {
            if (word.indexOf(pref) == 0)
                cnt++;
        }

        return cnt;
    }
}