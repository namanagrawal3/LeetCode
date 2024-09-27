class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                l.add(num);
            }
        }

        int[] ans = new int[l.size()];
        int idx = 0;
        for (int ele : l) {
            ans[idx++] = ele;
        }
        
        return ans;
    }
}