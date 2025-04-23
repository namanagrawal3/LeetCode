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
    public int sumNumbers(TreeNode root) {
        return sumFun(root, 0);
    }
    public int sumFun(TreeNode node, int num) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return num*10 + node.val;
         
        int left = sumFun(node.left, num*10 + node.val);
        int right = sumFun(node.right, num*10 + node.val);

        return left + right;
    }
}