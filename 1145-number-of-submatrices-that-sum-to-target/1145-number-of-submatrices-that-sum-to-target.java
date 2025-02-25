class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
    // Generate all the submatrices using prefix-sum 
    // then, count the subarray sum equals target (using prefix-sum with Hashmap) 
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            Arrays.fill(arr, 0);
            for (int k = i; k < m; k++) {
                for (int j = 0; j < n; j++) {
                    arr[j] += matrix[k][j];
                }
                count += subSumK(arr, target);
            }
        }

        return count;
    }
    public static int subSumK(int[] arr, int target) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currSum = 0;

        for (int num : arr) {
            currSum += num;
            int rem = currSum - target;
            if (map.containsKey(rem))
                count += map.get(rem);

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}