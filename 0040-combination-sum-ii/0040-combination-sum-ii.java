class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combFun(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void combFun(int[] coins, int amount, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (amount == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            if (i > idx && coins[i] == coins[i-1])
                continue;
                
            if (amount >= coins[i]) {
                l.add(coins[i]);
                combFun(coins, amount-coins[i], i+1, l, ans);
                l.remove(l.size()-1);
            }
        }
    }
}