class Solution {
    int ans;
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        ans = Integer.MAX_VALUE;

        int[] child = new int[k];
        solveFun(cookies, 0, child, k);

        return ans;
    }
    public void solveFun(int[] cookies, int idx, int[] child, int k) {
        if (idx == cookies.length) {
            ans = Math.min(ans, maxFun(child));
            return;
        }

        for (int i = 0; i < k; i++) {
            child[i] += cookies[idx];
            solveFun(cookies, idx+1, child, k);
            child[i] -= cookies[idx];
        }

    }
    public int maxFun(int[] child) {
        int max = child[0];
        for (int i = 1; i < child.length; i++) {
            max = Math.max(max, child[i]);
        }

        return max;
    }
}