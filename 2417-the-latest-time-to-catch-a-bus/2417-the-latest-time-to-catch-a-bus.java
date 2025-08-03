class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
    // We have to give the latest time (ie, max time) so we will catch only the last bus
    // So, move bruteforcely to each bus and check their passengers then for the last bus find the max time possible
     
        int n = buses.length;
        int m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int bi = 0, pi = 0;
        int capFilled = 0;
        while (bi < n) {
            capFilled = 0;
            while (capFilled < capacity && pi < m && passengers[pi] <= buses[bi]) {
                pi++;
                capFilled++;
            }
            bi++;
        }

        pi--;

        if (capFilled < capacity && (pi < 0 || buses[n-1] != passengers[pi]))
            return buses[n-1];

        while (pi > 0 && passengers[pi]-1 == passengers[pi-1]) {
            pi--;
        }
        return passengers[pi]-1;
    }
}