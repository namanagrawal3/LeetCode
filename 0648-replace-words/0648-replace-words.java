class Solution {
    class Node {
        char ch;
        HashMap<Character, Node> child = new HashMap<>();
        boolean isTerminal = false;
    }
    private Node root;
    public Solution() {
        root = new Node();
        root.ch = '*';
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.child.containsKey(ch)) {
                curr = curr.child.get(ch);
            }
            else {
                Node nn = new Node();
                nn.ch = ch;
                curr.child.put(ch, nn);
                curr = nn;
            }
        }

        curr.isTerminal = true;             // marking as Terminal Node (end of the word)
    }

    public String findRoot(String word) {
        StringBuilder ans = new StringBuilder();
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.child.containsKey(ch)) {
                ans.append(ch);
                curr = curr.child.get(ch);
                if (curr.isTerminal)
                    return ans.toString();
            }
            else
                return word;
        }

        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Solution tt = new Solution();
        for (String root : dictionary) {
            tt.insert(root);
        }

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String word: words) {
            ans.append(tt.findRoot(word));
            ans.append(" ");
        }

        return ans.toString().trim();   
    }
}