/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        int idx;
        public Pair(TreeNode n, int i) {
            node = n;
            idx = i;
        }
    }
    class DiPair {
        int val;
        int level;
        public DiPair(int v, int l) {
            val = v;
            level = l;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<DiPair>> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(root, 0));
        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                Pair rv = q.poll();
                TreeNode nn = rv.node;
                int idx = rv.idx;

                if (!map.containsKey(idx))
                    map.put(idx, new ArrayList<>());
                map.get(idx).add(new DiPair(nn.val, level));

                if (nn.left != null)
                    q.add(new Pair(nn.left, idx-1));
                if (nn.right != null)
                    q.add(new Pair(nn.right, idx+1));
            }
            level++;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            List<DiPair> ll = map.get(key);

            Collections.sort(ll, new Comparator<DiPair>() {
                @Override
                public int compare(DiPair o1, DiPair o2) {
                    if (o1.level == o2.level)
                        return o1.val - o2.val;
                    return o1.level - o2.level;
                }
            });

            List<Integer> l = new ArrayList<>();
            for (DiPair item : ll) {
                l.add(item.val);
            }
            ans.add(l);
        }

        return ans; 
    }
}