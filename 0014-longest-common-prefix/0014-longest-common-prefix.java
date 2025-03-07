class Solution {
    class Trie {
        class Node {
            char ch;
            HashMap<Character, Node> child = new HashMap<>();
            boolean isTerminal;
        }

        private Node root;
        public Trie() {
            root = new Node();
            root.ch = '*';
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.child.containsKey(ch)) 
                    curr = curr.child.get(ch);
                else {
                    Node nn = new Node();
                    nn.ch = ch;
                    curr.child.put(ch, nn);
                    curr = nn;
                }
            }
            curr.isTerminal = true;
        }

        public String prefix() {
            StringBuilder ans = new StringBuilder();
            Node curr = root;

            while (!curr.isTerminal) {
                if (curr.child.size() == 1) {
                    for (Character ch : curr.child.keySet()) {
                        ans.append(ch);
                        curr = curr.child.get(ch);
                    }
                }
                else 
                    return ans.toString();
            }

            return ans.toString(); 
        }
    }
    public String longestCommonPrefix(String[] strs) {
        Trie tt = new Trie();
        for (String word : strs) {
            tt.insert(word);
        }

        return tt.prefix();
    }
}