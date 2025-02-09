class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        long count = 0;
        long totalPairs = (1L * (n-1) * n) / 2;

        for (int fre : map.values()) {
            count += (1L * (fre-1) * fre) / 2;
        }
        return totalPairs - count;
    }
}