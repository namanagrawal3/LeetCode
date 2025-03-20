class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();        // Queen Combination
        combFun(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }
    public void combFun(int n, int k, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = idx; i <= n; i++) {
            l.add(i);
            combFun(n, k-1, i+1, l, ans);
            l.remove(l.size()-1);
        }
    }
}