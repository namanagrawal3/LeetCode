class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> ans = new ArrayList<>();// Queen Combination + Combination Sum
        combFun(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }
    public void combFun(int n, int k, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            if (n >= i) {
                l.add(i);
                combFun(n-i, k-1, i+1, l, ans);
                l.remove(l.size()-1);
            }
        }
    }
}