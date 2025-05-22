class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        Arrays.sort(queries, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> passedQuery = new PriorityQueue<>(); 
        int j = 0;
        int queryUsed = 0;
        
        for (int i = 0; i < n; i++) {
            while (j < q && queries[j][0] == i) {
                maxHeap.add(queries[j][1]);
                j++;
            }
            
            // First update the impact of the past queries
            nums[i] -= passedQuery.size();
            
            while (nums[i] > 0 && !maxHeap.isEmpty() && maxHeap.peek() >= i) {
                nums[i]--;
                queryUsed++;
                passedQuery.add(maxHeap.poll());                
            }
            
            if (nums[i] > 0)
                return -1;
            
            // remove the queries which are out of range
            while (!passedQuery.isEmpty() && passedQuery.peek() <= i) {
                passedQuery.poll();
            }
        }
        
        return q - queryUsed;
    }
}