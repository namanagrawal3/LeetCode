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
class FindElements {
    private HashSet<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        dfsFun(root, 0);
    }
    public void dfsFun(TreeNode node, int x) {
        if (node == null)
            return;
        
        node.val = x;
        set.add(x);

        dfsFun(node.left, 2*x + 1);
        dfsFun(node.right, 2*x + 2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */