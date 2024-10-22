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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> l = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode rv = q.poll();

                if (rv.left != null)
                    q.add(rv.left);
                if (rv.right != null)
                    q.add(rv.right);

                sum += rv.val;
            }
            l.add(sum);
        }

        if (l.size() < k)
            return -1;

        Collections.sort(l);
        return l.get(l.size() - k);
    }
}