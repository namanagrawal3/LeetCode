class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
    // Simple use the 'Line Sweep' technique (have to merge overlap intervals)
    // but here we need to use the 'TreeMap' instead of '2D array'

        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int[] s: segments) {
            int start = s[0];
            int end = s[1];
            int color = s[2];

            map.put(start, map.getOrDefault(start, 0L) + color);
            map.put(end, map.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> ans = new ArrayList<>();
        long curr = 0;
        int prevEvent = 0;

        for (int event : map.keySet()) {
            if (prevEvent != 0 && curr > 0)
                ans.add(Arrays.asList((long) prevEvent, (long) event, curr));

            curr += map.get(event);
            prevEvent = event;
        }

        return ans;
    }
}