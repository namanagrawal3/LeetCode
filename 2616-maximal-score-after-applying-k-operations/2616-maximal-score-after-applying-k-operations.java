class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int ele : nums) {
            pq.add(ele);
        }

        for (int i = 0; i < k; i++) {
            int temp = pq.poll();
            score += temp;
            pq.add((int)Math.ceil(temp/3.0));
        }
        
        return score;
    }
}