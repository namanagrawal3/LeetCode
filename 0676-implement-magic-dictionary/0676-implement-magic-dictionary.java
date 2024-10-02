class MagicDictionary {
    private String[] dict;

    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        dict = dictionary;
    }
    
    public boolean search(String searchWord) {
        for (String word : dict) {
            if (word.length() == searchWord.length()) {
                int cnt = 0;
                int n = word.length();
                
                for (int i = 0; i < n; i++) {
                    if (word.charAt(i) != searchWord.charAt(i))
                        cnt++;
                    if (cnt > 1)
                        break;    
                }
                if (cnt == 1)
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */