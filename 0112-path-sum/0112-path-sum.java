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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkFun(root, targetSum);
    }
    public boolean checkFun(TreeNode node, int target) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return target-node.val == 0;

        boolean left = checkFun(node.left, target-node.val);
        boolean right = checkFun(node.right, target-node.val);

        return left || right;
    }
}