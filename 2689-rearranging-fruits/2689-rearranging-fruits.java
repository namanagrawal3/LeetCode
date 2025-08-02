class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int b: basket1) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        for (int b: basket2) {
            map.put(b, map.getOrDefault(b, 0) - 1);
        }
        
        List<Integer> ll = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int key: map.keySet()) {
            min = Math.min(min, key);
            int fre = Math.abs(map.get(key));

            if (fre == 0)
                continue;
            if (fre % 2 != 0)
                return -1;

            for (int i = 0; i < fre/2; i++) {
                ll.add(key);
            }
        }

        // We can also do the indirect-swapping using the min element (swapping 2 times)
        Collections.sort(ll);
        long sum = 0;
        for (int i = 0; i < ll.size()/2; i++) {
            sum += Math.min(ll.get(i), 2*min);        
        }

        return sum;
    }
}