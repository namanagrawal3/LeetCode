class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        subsetFun(nums, 0, l, ans);
        return ans;
    }
    public void subsetFun(int[] nums, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(l));
            return;
        }

        l.add(nums[idx]);
        subsetFun(nums, idx+1, l, ans);         // take
        l.remove(l.size()-1); 

        subsetFun(nums, idx+1, l, ans);         // not-take    
    }
}