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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            int max = q.peek().val;
            
            while (n-- > 0) {
                TreeNode rv = q.poll();
                if (rv.val > max)
                    max = rv.val;

                if (rv.left != null)
                    q.add(rv.left);
                if (rv.right != null)
                    q.add(rv.right);
            }
            ans.add(max);
        }

        return ans;
    }
}