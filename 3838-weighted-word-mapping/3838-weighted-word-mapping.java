class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
    // Simply, do the iteration

        StringBuilder s = new StringBuilder();
        for (String word: words) {
            s.append(weightFun(word, weights));
        }

        return s.toString();
    }
    public char weightFun(String s, int[] weights) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            sum += weights[idx];
        }

        sum = sum % 26;
        return (char) ('z' - sum);
    } 
}