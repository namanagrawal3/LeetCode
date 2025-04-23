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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        checkFun(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
    public void checkFun(TreeNode node, int target, List<Integer> l, List<List<Integer>> ans) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            if (target-node.val == 0) {
                l.add(node.val);
                ans.add(new ArrayList<>(l));
                l.remove(l.size() - 1);
            }
            return;
        }    

        l.add(node.val);

        checkFun(node.left, target-node.val, l, ans);
        checkFun(node.right, target-node.val, l, ans);

        l.remove(l.size() - 1);
    }
}