class Solution {
    class Pair {
        String word;
        int idx;
        public Pair(String s, int i) {
            word = s;
            idx = i;
        }
    }

    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = words[0].toLowerCase();
        int n = words.length;

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(words[i], i);
        }

        Arrays.sort(arr, (a, b) -> (a.word.length() != b.word.length()) ? a.word.length() - b.word.length() : a.idx - b.idx);

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = arr[i].word;
            if (i == 0) {
                s = (char) (s.charAt(0) - 32) + "" + s.substring(1);
            }
            ans.append(s +" ");
        }

        return ans.toString().strip();
    }
}