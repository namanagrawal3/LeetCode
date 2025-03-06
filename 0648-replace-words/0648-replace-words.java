class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        for (String root : dictionary) {
            set.add(root);
        }

        for (String word : words) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                temp.append(ch);

                if (set.contains(temp.toString()))
                    break;
            }
            ans.append(temp);
            ans.append(" ");
        }

        return ans.toString().trim();
    }
}