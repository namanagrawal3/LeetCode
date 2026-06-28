class MyCalendarThree {
// Simple use the 'Line Sweep' technique (need to count max overlap)
    private List<int[]> events;

    public MyCalendarThree() {
        events = new ArrayList<>();   
    }
    
    public int book(int startTime, int endTime) {
        events.add(new int[]{startTime, 1});
        events.add(new int[]{endTime, -1});

        Collections.sort(events, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        return maxOverLapFun(events);
    }

    private int maxOverLapFun(List<int[]> events) {
        int maxOverlap = 0;
        int curr = 0;

        for (int[] e: events) {
            curr += e[1];
            if (curr > maxOverlap)
                maxOverlap = curr;
        }

        return maxOverlap;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */