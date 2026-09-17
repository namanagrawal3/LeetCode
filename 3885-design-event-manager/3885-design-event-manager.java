class EventManager {
// Simply, Keep the track of active events with their correct priority in the 'HashMap' & Maintain all the events (old & updated priority) in the 'Priority Queue'

    private PriorityQueue<int[]> pq;
    private HashMap<Integer, Integer> map;

    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a,b) -> (a[1] == b[1]) ? a[0]-b[0] : b[1]-a[1]);
        map = new HashMap<>();

        for (int[] e: events) {
            pq.add(e);
            map.put(e[0], e[1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        if (!map.containsKey(eventId))
            return;
        
        map.put(eventId, newPriority);
        pq.add(new int[]{eventId, newPriority});
    }
    
    public int pollHighest() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            
            if (!map.containsKey(top[0]) || map.get(top[0]) != top[1])
                continue;

            map.remove(top[0]);
            return top[0];
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */