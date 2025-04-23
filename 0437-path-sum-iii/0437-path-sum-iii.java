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
    int paths;
    public int pathSum(TreeNode root, int targetSum) {
    // similar to 'Count Subarrays sum equals k' (prefix sum using HashMap)

    if (root == null)
        return 0;

    HashMap<Long, Integer> map = new HashMap<>();
    map.put(0L, 1);

    paths = 0;
    countPaths(root, targetSum, 0, map);
    return paths;
    }
    public void countPaths(TreeNode node, int k, long currSum, HashMap<Long, Integer> map) {
        if (node == null)
            return;

        currSum += node.val;
        if (map.containsKey(currSum - k))
            paths += map.get(currSum - k);
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        countPaths(node.left, k, currSum, map);
        countPaths(node.right, k, currSum, map);

        map.put(currSum, map.get(currSum) - 1);  // need to remove the visited nodes 
        if (map.get(currSum) == 0)
            map.remove(currSum);
    }
}