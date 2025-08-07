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
        minMoves(root);
        
        return moves;
    }
    public int minMoves(TreeNode node) {
        if (node == null)
            return 0;

        int left = minMoves(node.left);
        int right = minMoves(node.right);

        moves += Math.abs(left) + Math.abs(right);
        return (left + right + node.val) - 1;
    }
}