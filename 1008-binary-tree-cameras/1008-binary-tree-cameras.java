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
    int camera;

    public int minCameraCover(TreeNode root) {
        // There are 2 types of nodes: one with camera and one without camera
        // node without camera would be either covered or need to be covered with camera  
        // Thus, 3 states are -
        // you need a camera to be covered: -1
        // you have a camera: 0
        // you are covered with a camera: 1
        
        camera = 0;
        
        int x = minFun(root);
        if (x == -1)
            camera++;

        return camera;
    }
    public int minFun(TreeNode node) {
        if (node == null)
            return 1;
        if (node.left == null && node.right == null)
            return -1;
        
        int left = minFun(node.left);
		int right = minFun(node.right);

        if (left == -1 || right == -1) {
            camera++;
            return 0;       // camera setup kra hai
        } 
        else if (left == 0 || right == 0) 
            return 1;       // already child se covered hai
        else 
            return -1;      // Node pe Camera ki need hai
    }
}