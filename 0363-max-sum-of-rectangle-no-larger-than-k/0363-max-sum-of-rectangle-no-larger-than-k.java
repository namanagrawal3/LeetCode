class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    // comb of 2-Prob : Maximum sum of submatrix (rectangle), maximum subarray sum atmost k 
        int m =  matrix.length;
        int n = matrix[0].length;
        
        int maxSum = Integer.MIN_VALUE;
        int[] sum = new int[n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(sum, 0);

            for (int j = i; j < m; j++) {
                for (int col = 0; col < n; col++) {
                    sum[col] += matrix[j][col];
                }
                
                maxSum = Math.max(maxSum, sumFun(sum, k));
            }
        }
        
        return maxSum;
    }
    public int sumFun(int[] arr, int k) {               // pre[j] - pre[i] <= k 
        int n = arr.length;                             // pre[j] - k <= pre[i]
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {
            currSum += num;
            Integer target = set.ceiling(currSum - k);

            if (target != null)
                maxSum = Math.max(maxSum, currSum-target);
            set.add(currSum);
        }

        return maxSum;
    }
}