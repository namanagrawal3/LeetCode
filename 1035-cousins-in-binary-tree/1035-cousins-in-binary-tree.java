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
    public boolean isCousins(TreeNode root, int x, int y) {
        // checking whether the levels of x & y are same or not
        int l1 = -1, l2 = -1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode rv = q.poll();
                if (rv.val == x)
                    l1 = level;
                if (rv.val == y)
                    l2 = level;

                if (rv.left != null)
                    q.add(rv.left);
                if (rv.right != null)
                    q.add(rv.right);
            }
            level++;
        }

        if (l1 != l2)
            return false;

        // checking whether parents of x & y are different or not
        return !sameParent(root, x, y);
    }
    public boolean sameParent(TreeNode node, int x, int y) {
        if (node == null)
            return false;

        if (node.left != null && node.right != null) {
            if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))
                return true;
        }

        boolean left = sameParent(node.left, x, y);
        boolean right = sameParent(node.right, x, y);
        return left || right;
    }
}