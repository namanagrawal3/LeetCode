class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int cnt = 0;
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, 0);
                cnt++;
            }
        }

        int[] ans = new int[cnt];
        for (int key : map.keySet()) {
            if (map.get(key) == 0)
                ans[--cnt] = key;
        }
        return ans;
    }
}