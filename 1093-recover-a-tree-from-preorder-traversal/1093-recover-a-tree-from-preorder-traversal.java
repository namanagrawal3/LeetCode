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
    int maxIdx;
    public TreeNode recoverFromPreorder(String traversal) {
        maxIdx = 0;
        return consTree(traversal, 0, 0);
    }
    public TreeNode consTree(String trav, int i, int currD) {
        int j = i;
        while (j < trav.length() && trav.charAt(j) == '-') {
            j++;
        }

        if (j-i != currD)
            return null;

        StringBuilder val = new StringBuilder();
        while (j < trav.length() && trav.charAt(j) != '-') {
            val.append(trav.charAt(j));
            j++;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val.toString()));
        
        maxIdx = Math.max(maxIdx, j);
        root.left = consTree(trav, j, currD + 1);
        root.right = consTree(trav, maxIdx, currD + 1);

        return root;    
    }
}