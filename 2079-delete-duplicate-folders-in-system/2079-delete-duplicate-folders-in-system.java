class Solution {
    class Trie {
        class Node {
            String name;
            String subFolder;
            HashMap<String, Node> child = new HashMap<>();

        }

        private Node root;
        public Trie() {
            root = new Node();
            root.name = "/";
        }

        public void insert(List<String> path) {
            Node curr = root;
            int i = 0;
            while (i < path.size()) {
                if (curr.child.containsKey(path.get(i))) {
                    curr = curr.child.get(path.get(i));
                } else {
                    Node nn = new Node();
                    nn.name = path.get(i);
                    curr.child.put(path.get(i), nn);
                    curr = nn;
                }
                i++;
            }
        }

        public void subFolders(HashMap<String, Integer> map) {
            dfsFun(root, map);
        }
        private String dfsFun(Node curr, HashMap<String, Integer> map) {
            List<String> l = new ArrayList<>();
            for (String s: curr.child.keySet()) {
                String subPath = dfsFun(curr.child.get(s), map);
                l.add(subPath);
            }

            Collections.sort(l);
            StringBuilder subFolder = new StringBuilder();
            for (String s: l) {
                subFolder.append(s);
            }

            curr.subFolder = subFolder.toString();
            map.put(curr.subFolder, map.getOrDefault(curr.subFolder, 0) + 1);

            String rv = "(" + curr.name + curr.subFolder + ")";
            return rv;
        }

        public void check(HashMap<String, Integer> map, List<String> l, List<List<String>> ans) {
            for (String s: root.child.keySet()) {
                Node nxt = root.child.get(s);
                if (!nxt.subFolder.equals("") && map.get(nxt.subFolder) > 1) 
                    continue;
                
                l.add(s);
                ans.add(new ArrayList<>(l));
                dfsCheck(nxt, map, l, ans);
                l.remove(l.size()-1);
            }
        }
        private void dfsCheck(Node curr, HashMap<String, Integer> map, List<String> l, List<List<String>> ans) {
            for (String s: curr.child.keySet()) {
                Node nxt = curr.child.get(s);
                if (!nxt.subFolder.equals("") && map.get(nxt.subFolder) > 1)
                    continue;

                l.add(s);
                ans.add(new ArrayList<>(l));
                dfsCheck(nxt, map, l, ans);
                l.remove(l.size()-1);
            }
        }

    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // creating the trie
        Trie t = new Trie();
        for (List<String> path: paths) {
            t.insert(path);
        }

        // finding the subFolder structures and storing their frequencies
        HashMap<String, Integer> map = new HashMap<>();
        t.subFolders(map);

        // checking all the subFolder structures
        List<List<String>> ans = new ArrayList<>();
        t.check(map, new ArrayList<>(), ans);

        return ans;
    }
}