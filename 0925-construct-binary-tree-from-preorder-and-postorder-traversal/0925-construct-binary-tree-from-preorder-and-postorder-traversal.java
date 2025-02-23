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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return consTree(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
    }
    public TreeNode consTree(int[] pre, int[] post, int prsi, int prei, int posi, int poei) {
        if (prsi > prei || posi > poei)
            return null;
        if (prsi == prei || posi == poei)
            return new TreeNode(pre[prsi]);

        int target = pre[prsi+1];
        int idx = findIdx(post, posi, poei, target);
        int len = idx-posi+1;

        TreeNode root = new TreeNode(pre[prsi]);
        root.left = consTree(pre, post, prsi+1, prsi+len, posi, idx);
        root.right = consTree(pre, post, prsi+len+1, prei, idx+1, poei-1);

        return root;
    }
    public int findIdx(int[] post, int si, int ei, int target) {
        for (int i = si; i <= ei; i++) {
            if (post[i] == target)
                return i;
        }
        return -1; 
    }
}