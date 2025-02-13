class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(1L*num);
        }

        int opr = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= k)
                return opr;

            long x = pq.poll();
            long y = pq.poll();
            long z = Math.min(x, y)*2 + Math.max(x, y);

            pq.add(z);
            opr++;
        }

        return opr;
    }
}