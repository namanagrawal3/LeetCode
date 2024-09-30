class Solution {
    public String longestWord(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String str : words) {
            set.add(str);
        }

        String maxLenWord = "";
        for (String word : words) {
            int cnt = 0;
            for (int i = 0; i < word.length()-1; i++) {
                if (!set.contains(word.substring(0, i+1)))
                    break;
                cnt++;
            }

            if (cnt == word.length()-1) {
                if (word.length() > maxLenWord.length())
                    maxLenWord = word;
                else if (word.length() == maxLenWord.length()) {
                    if (word.compareTo(maxLenWord) < 0)
                        maxLenWord = word;
                }
            }
        }

        return maxLenWord;
    }
}