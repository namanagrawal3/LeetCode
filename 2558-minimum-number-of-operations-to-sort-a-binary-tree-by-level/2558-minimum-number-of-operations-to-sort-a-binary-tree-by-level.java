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
    public int minimumOperations(TreeNode root) {
        int swaps = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> l = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode rv = q.poll();

                if (rv.left != null)
                    q.add(rv.left);
                if (rv.right != null)
                    q.add(rv.right);

                l.add(rv.val); 
            }

            swaps += countSwap(l);
        }
        return swaps;
    }
    public static int countSwap(List<Integer> l) {
        int n = l.size();
        int[][] arr= new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = l.get(i);
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[1], b[1]));
        int count = 0;

        for (int i = 0; i < n; i++) {

            while (arr[i][0] != i) {
                int idx = arr[i][0];
                int temp = arr[idx][0];
                arr[idx][0] = idx;
                arr[i][0] = temp;
                count++;
            }
        }
        return count;
    }
}