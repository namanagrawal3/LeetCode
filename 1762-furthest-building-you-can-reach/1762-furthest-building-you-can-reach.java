class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
    // Approach-1 : Recursion (trying all possible ways) --> MLE
    // Approach-2 : Lazy Greedy (use ladders for the very big buildings and bricks for small buildings)
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap

        int i = 0;
        for (; i < n-1; i++) {
            int diff = heights[i+1] - heights[i];
            if (diff <= 0)
                continue;

            if (bricks >= diff) {
                bricks -= diff;
                pq.add(diff);
            }
            else if (ladders > 0) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > diff) {
                        bricks += pq.poll();
                        bricks -= diff;
                        pq.add(diff);
                        ladders--;
                    }
                    else
                        ladders--;
                }
                else
                    ladders--;
            }
            else
                break;
        }

        return i;
    }
}