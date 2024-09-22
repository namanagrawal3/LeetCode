class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int count = countFun(curr, curr+1, n);
            if (count <= k) {
                curr++;
                k -= count;
            }
            else {
                curr *= 10;
                k--; 
            }
        }

        return curr;
    }
    public int countFun(long curr, long next, int n) {
        int count = 0;
        while (curr <= n) {
            count += next - curr;
            curr *= 10;
            next *= 10;
            next = Math.min(next, n+1);
        }
        return count;
    }
}