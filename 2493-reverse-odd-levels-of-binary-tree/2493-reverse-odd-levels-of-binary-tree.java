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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return null;

        solveFun(root.left, root.right, 1);         // just like "Mirror Image"
        return root;
    }
    public void solveFun(TreeNode leftNode, TreeNode rightNode, int level) {
        if (leftNode == null)
            return;

        if (level % 2 == 1) {
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
        }

        solveFun(leftNode.left, rightNode.right, level+1);
        solveFun(leftNode.right, rightNode.left, level+1);   
    }
}