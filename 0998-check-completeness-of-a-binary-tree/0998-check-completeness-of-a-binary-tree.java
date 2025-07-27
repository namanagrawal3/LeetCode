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
    public boolean isCompleteTree(TreeNode root) {
        int n = countNodes(root);
        return checkFun(root, n, 0);

    }
    public int countNodes(TreeNode node) {
        if (node == null)
            return 0;

        int left = countNodes(node.left);
        int right = countNodes(node.right);
        return left + right + 1;
    }
    public boolean checkFun(TreeNode node, int n, int i) {
        if (node == null)
            return true;

        if (i >= n)
            return false;

        boolean left = checkFun(node.left, n, 2*i + 1);
        boolean right = checkFun(node.right, n, 2*i + 2);
        return left && right;   
    }
}