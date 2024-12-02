class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i].indexOf(searchWord) == 0)
                return i+1;
        }

        return -1;
    }
}