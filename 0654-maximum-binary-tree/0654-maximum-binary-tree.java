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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return createTree(nums, 0, n-1);
    }
    public TreeNode createTree(int[] nums, int si, int ei) {
        if (si > ei)
            return null;

        int maxIdx = si;
        for (int i = si+1; i <= ei; i++) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = createTree(nums, si, maxIdx-1);
        root.right = createTree(nums, maxIdx+1, ei);

        return root;
    }
}