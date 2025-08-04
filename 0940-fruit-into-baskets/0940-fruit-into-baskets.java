class Solution {
    public int totalFruit(int[] fruits) {
    // find the longest subarray with atmost 2 distinct elements
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int si = 0, ei = 0;

        while (ei < n) {
            map.put(fruits[ei], map.getOrDefault(fruits[ei], 0) + 1);

            while (map.size() > 2 && si <= ei) {
                map.put(fruits[si], map.get(fruits[si]) - 1);
                if (map.get(fruits[si]) == 0)
                    map.remove(fruits[si]);
                si++;
            }

            maxLen = Math.max(maxLen, ei-si+1);
            ei++;
        }

        return maxLen;
    }
}