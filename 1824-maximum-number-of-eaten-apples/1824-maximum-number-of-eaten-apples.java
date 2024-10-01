class Solution {
    class Pair {
        int apple;          // no. of apples
        int lastDay;        // last day after which apple will be rotten
        public Pair(int app, int day) {
            this.apple = app;
            this.lastDay = day;
        }
    }
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {    // min-Heap
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.lastDay - o2.lastDay;
            }
        });

        int n = apples.length;
        int cnt = 0;
        int idx = 0;          // curr_day  
        
        while (!pq.isEmpty() || idx < n) {
            if (idx < n && apples[idx] != 0)
                pq.add(new Pair(apples[idx], idx+days[idx]-1));

            while (!pq.isEmpty() && pq.peek().lastDay < idx) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                Pair rv = pq.poll();
                cnt++;
                if (rv.apple-1 > 0 && rv.lastDay > idx)
                    pq.add(new Pair(rv.apple-1, rv.lastDay));
            }            
            idx++;
        }

        return cnt;
    }
}