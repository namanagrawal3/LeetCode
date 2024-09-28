class Solution {
    public int longestConsecutive(int[] nums) {
        // Approach-2 : using HashMap

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num-1))
                map.put(num, false);
            else
                map.put(num, true);

            if (map.containsKey(num+1))
                map.put(num+1, false);
        }

        int maxLen = 0;
        for (int key : map.keySet()) {
            if (map.get(key)) {
                int cnt = 0;
                while (map.containsKey(key)) {
                    cnt++;
                    key++;
                }
                maxLen = Math.max(maxLen, cnt);
            }
        }
        return maxLen;
    }
}