class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums[0]) {
            map.put(num, 1);
        }

        for (int i = 1; i < n; i++) {
            for (int num : nums[i]) {
                if (map.containsKey(num))
                    map.put(num, map.get(num) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == n)
                ans.add(key);
        }
        Collections.sort(ans);
        return ans;
    }
}