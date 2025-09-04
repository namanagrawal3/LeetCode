class Solution {
    class Node {
        char ch;
        HashMap<Character, Node> child = new HashMap<>();
        boolean isTerminal = false;
    }

    class Trie {
        private Node root;
        public Trie() {
            root = new Node();
            root.ch = '*';
        }
        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.child.containsKey(ch)) {
                    curr = curr.child.get(ch);
                } else {
                    Node nn = new Node();
                    nn.ch = ch;
                    curr.child.put(ch, nn);
                    curr = nn;
                }
            }
            curr.isTerminal = true;
        }
        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.child.containsKey(ch))
                    curr = curr.child.get(ch);
                else
                    return false;
            }
            return curr.isTerminal;
        }
        public boolean check(String s, HashMap<String, Boolean> dp) {
            if (s.length() == 0)
                return true;
            if (dp.containsKey(s))
                return dp.get(s);

            for (int i = 0; i < s.length(); i++) {
                String part = s.substring(0, i+1);
                if (search(part)) {
                    boolean ans = check(s.substring(i+1), dp);
                    if (ans) {
                        dp.put(s, true);
                        return true;
                    }    
                }
            }

            dp.put(s, false);
            return false;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie();
        for (String word: wordDict) {
            t.insert(word);
        }

        HashMap<String, Boolean> dp = new HashMap<>();
        return t.check(s, dp);
    }
}