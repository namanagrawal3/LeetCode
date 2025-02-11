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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> l = new ArrayList<>();
        inOrder(root, l);

        l.add(val);
        return createTree(l, 0, l.size()-1);
    }
    public void inOrder(TreeNode node, List<Integer> l) {
        if (node == null)
            return;

        inOrder(node.left, l);
        l.add(node.val);
        inOrder(node.right, l);
    }
    public TreeNode createTree(List<Integer> l, int si, int ei) {
        if (si > ei)
            return null;

        int maxIdx = si;
        for (int i = si+1; i <= ei; i++) {
            if (l.get(i) > l.get(maxIdx))
                maxIdx = i;
        }

        TreeNode root = new TreeNode(l.get(maxIdx));
        root.left = createTree(l, si, maxIdx-1);
        root.right = createTree(l, maxIdx+1, ei);

        return root;
    }
}