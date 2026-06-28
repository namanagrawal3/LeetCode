class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
    // Range (Interval) based problem , so try 'Line Sweep' or 'Difference Array' technique
    // 'Difference Array' tecnique would be more suitable here.

        int[] diff = new int[n];

        for (int[] book: bookings) {
            int start = book[0] - 1;
            int end = book[1] - 1;
            int seat = book[2];

            diff[start] += seat;
            if (end+1 < n)
                diff[end+1] -= seat;
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i-1];
        }

        return diff;
    }
}