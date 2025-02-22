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
    int idx;
    public TreeNode recoverFromPreorder(String traversal) {
        idx = 0;
        return consTree(traversal, 0);
    }
    public TreeNode consTree(String trav, int currD) {
        int j = idx;
        while (j < trav.length() && trav.charAt(j) == '-') {
            j++;
        }

        if (j-idx != currD)
            return null;

        int val = 0;
        idx = j;
        while (idx < trav.length() && trav.charAt(idx) != '-') {
            val = val*10 + (trav.charAt(idx)-'0');
            idx++;
        }

        TreeNode root = new TreeNode(val);
        root.left = consTree(trav, currD + 1);
        root.right = consTree(trav, currD + 1);

        return root;      
    }
}