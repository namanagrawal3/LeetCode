class Solution {
    public long maxMatrixSum(int[][] matrix) {
// Even no. of negative no. will all become positive
// Odd no. of negative no. will lead to only 1 negative no (we can transfer the '-' sign)
        int n = matrix.length;
        long sum = 0;
        int neg = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                sum += Math.abs(num);

                if (num < 0)
                    neg++;
                if (Math.abs(num) < min)
                    min = Math.abs(num);
            }
        }

        if (neg % 2 == 0)
            return sum;
        return sum - 2*min;
    }
}