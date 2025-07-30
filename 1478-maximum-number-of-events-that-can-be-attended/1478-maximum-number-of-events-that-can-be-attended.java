class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        // sort on the basis of start-point
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        // minHeap storing the events possible on currDay 
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int currDay = events[0][0];
        int count = 0;
        int i = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty())
                currDay = events[i][0];
            
            // adding the events possible on currDay
            while (i < n && events[i][0] == currDay) {
                pq.add(events[i]);
                i++;
            }

            // removing the ended events which are now not possible on currDay
            while (!pq.isEmpty() && pq.peek()[1] < currDay) {
                pq.poll();
            }
            
            // attending the earlier ending event (among all possible events on currDay)
            if (!pq.isEmpty()) {
                count++;
                pq.poll();            
            }

            currDay++;    
        }

        return count; 
    }
}