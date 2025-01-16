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
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        countFun(root);
        return moves;
    }
    public int countFun(TreeNode node) {
        if (node == null)
            return 0;

        int leftExtra = countFun(node.left);        // left moves
        int rightExtra = countFun(node.right);      // right moves

        moves += Math.abs(leftExtra) + Math.abs(rightExtra);

        return (leftExtra + rightExtra + node.val) - 1;           
    }
}