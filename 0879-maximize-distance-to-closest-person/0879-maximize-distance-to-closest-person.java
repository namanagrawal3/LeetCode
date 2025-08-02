class Solution {
    public int maxDistToClosest(int[] seats) {
    // sit either at start, end or in-between the seated persons
     
        int n = seats.length;
        List<Integer> occupied = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1)
                occupied.add(i);
        }

        int m = occupied.size();
        int maxDist = Math.max(occupied.get(0), n-1 - occupied.get(m-1));

        for (int i = 0; i < m-1; i++) {
            int dist = (occupied.get(i+1) - occupied.get(i)) / 2;
            maxDist = Math.max(maxDist, dist);
        }

        return maxDist;
    }
}