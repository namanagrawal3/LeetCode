class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    // Simple use 'Line Sweep' technique (Range - Interval based problem)
        
        int n = trips.length;
        int[][] events = new int[n*2][2];

        for (int i = 0; i < n; i++) {       // (2,1,5) -> (1, +2) & (5, -2)
            events[i][0] = trips[i][1];
            events[i][1] = trips[i][0];
            events[i+n][0] = trips[i][2];
            events[i+n][1] = -trips[i][0];
        } 

        Arrays.sort(events, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);

        int curr = 0;
        for (int[] e: events) {
            curr += e[1];
            if (curr > capacity)
                return false;
        }

        return true;
    }
}