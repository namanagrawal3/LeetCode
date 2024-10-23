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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {          // computing the sum of each level
            int size = q.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode rv = q.poll();
                sum += rv.val;

                if (rv.left != null)
                    q.add(rv.left);
                if (rv.right != null)
                    q.add(rv.right);
            }
            levelSum.add(sum);
        }

                                                
        q.add(root);
        root.val = 0;
        int level = 1;

        while (!q.isEmpty()) {         // subtract the siblingSum from the levelSum
            int size = q.size();
            while (size-- > 0) {
                TreeNode rv = q.poll();

                int siblingSum = 0;
                if (rv.left != null)
                    siblingSum += rv.left.val;
                if (rv.right != null)
                    siblingSum += rv.right.val;

                if (rv.left != null) {
                    rv.left.val = levelSum.get(level) - siblingSum;
                    q.add(rv.left);
                }    
                if (rv.right != null) {
                    rv.right.val = levelSum.get(level) - siblingSum;
                    q.add(rv.right);
                }                
            }
            level++;
        }
        return root;
    }
}