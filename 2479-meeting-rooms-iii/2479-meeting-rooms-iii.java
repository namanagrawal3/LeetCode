class Solution {
    class Pair {
        int endTime;
        int room;
        public Pair(int et, int r) {
            endTime = et;
            room = r;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        // sort meetings on the basis of start-point
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] meetCount = new int[n];
        PriorityQueue<Pair> usedRooms = new PriorityQueue<>((a, b) -> (a.endTime == b.endTime) ? a.room - b.room : a.endTime - b.endTime);
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }

        for (int[] meet: meetings) {
            int start = meet[0];
            int end = meet[1];
            int duration = end - start;

            // check which meetings have now ended and rooms get free before the current new-meeting
            while (!usedRooms.isEmpty() && usedRooms.peek().endTime <= start) {
                availableRooms.add(usedRooms.poll().room);
            }

            // assign meeting to the room if available otherwise, to the small ending time meeting's room
            if (availableRooms.isEmpty()) {
                Pair rv = usedRooms.poll();
                meetCount[rv.room]++;
                rv.endTime += duration;
                usedRooms.add(rv);
            }
            else {
                int room = availableRooms.poll();
                meetCount[room]++;
                usedRooms.add(new Pair(end, room));
            }
        }

        int maxCntRoom = 0;
        for (int i = 1; i < n; i++) {
            if (meetCount[i] > meetCount[maxCntRoom])
                maxCntRoom = i;
        }

        return maxCntRoom;
    }
}