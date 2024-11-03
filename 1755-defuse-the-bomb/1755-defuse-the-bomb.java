class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];             // using 'Fixed-size' sliding window

        if (k > 0) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += code[i];
            }

            for (int i = 0; i < n; i++) {
                sum += code[(i+k) % n];
                sum -= code[i];
                ans[i] = sum;
            }
        }
        else if (k < 0) {
            int sum = 0;
            for (int i = n-1; i >= n+k; i--) {
                sum += code[(i+n) % n];
            }

            for (int i = n-1; i >= 0; i--) {
                sum += code[(i+k+n) % n];
                sum -= code[i];
                ans[i] = sum;
            }
        }

        return ans;
    }
}