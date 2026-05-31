class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
    // Simply store the indices for each element, then use binary Search

        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int q: queries) {
            int num = nums[q];
            ans.add(binFun(map.get(num), q, n));  
        }

        return ans;
    }
    public int binFun(List<Integer> l, int idx, int td) {
        int n = l.size();
        if (n == 1)
            return -1;

        int si = 0;
        int ei = n-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (l.get(mid) == idx) {
                if (idx > l.get(0) && idx < l.get(n-1))
                    return Math.min(idx - l.get(mid-1), l.get(mid+1) - idx);
                else if (idx == l.get(0))
                    return Math.min(td - (l.get(n-1) - idx), l.get(mid+1) - idx);
                else 
                    return Math.min(td - (idx - l.get(0)), idx - l.get(mid-1));
            }
            else if (l.get(mid) < idx)
                si = mid + 1;
            else
                ei = mid - 1;
        }
        return -1;
    }
}