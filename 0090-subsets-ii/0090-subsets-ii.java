class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
// We will generate subsets starting with each unique element (i.e, lexicographically)
// and we will avoid the call for the duplicate elements (call only for first occurence)

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        subSetFun(nums, 0, l, ans);
        return ans;
    }
    public void subSetFun(int[] arr, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(l));
            return;
        }

        ans.add(new ArrayList<>(l));

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i-1])
                continue;

            l.add(arr[i]);
            subSetFun(arr, i+1, l, ans);
            l.remove(l.size()-1);
        }
    }
}