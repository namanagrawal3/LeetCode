class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];

        int[] pre = new int[n];         // stores the forward Kadane's sum
        int[] suf = new int[n];         // stores the backward Kadane's sum

        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(arr[i], pre[i-1] + arr[i]);
        }

        suf[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            suf[i] = Math.max(arr[i], suf[i+1] + arr[i]);
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i-1;
            int r = i+1;

            int leftSum = (l < 0) ? 0 : pre[l];
            int rightSum = (r == n) ? 0 : suf[r];

            int temp = Math.max(leftSum + rightSum, Math.max(pre[i], suf[i]));
            maxSum = Math.max(maxSum, temp);
        }

        return maxSum;
    }
}