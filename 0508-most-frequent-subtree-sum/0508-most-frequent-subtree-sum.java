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
    int maxFre;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        maxFre = 0;
        sumFun(root, map);
        
        List<Integer> temp = new ArrayList<>();
        for (int sum : map.keySet()) {
            if (map.get(sum) == maxFre)
                temp.add(sum);
        }

        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
    public int sumFun(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null)
            return 0;

        int left = sumFun(root.left, map);
        int right = sumFun(root.right, map);

        int currSum = left + root.val + right;
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        maxFre = Math.max(maxFre, map.get(currSum));

        return currSum;
    }
}