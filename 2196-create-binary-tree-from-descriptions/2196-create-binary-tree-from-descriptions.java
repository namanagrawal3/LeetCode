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
    public TreeNode createBinaryTree(int[][] des) {
    // Simply, first find the Root (by checking the child) and create a tree using HashMap
     
        int n = des.length;
        HashSet<Integer> child = new HashSet<>();

        for (int i = 0; i < n; i++) {
            child.add(des[i][1]);
        }

        int rootVal = -1;
        for (int i = 0; i < n; i++) {
            if (!child.contains(des[i][0]))
                rootVal = des[i][0];
        }
        
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(des[i][0])) 
                map.put(des[i][0], new TreeNode(des[i][0]));
            if (!map.containsKey(des[i][1])) 
                map.put(des[i][1], new TreeNode(des[i][1]));

            if (des[i][2] == 1)
                map.get(des[i][0]).left = map.get(des[i][1]);
            else
                map.get(des[i][0]).right = map.get(des[i][1]);
        }

        return map.get(rootVal); 
    }
}