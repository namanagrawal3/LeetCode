class Solution {
    public long minNumberOfSeconds(int height, int[] times) {
        int n = times.length;
        Arrays.sort(times);

        long si = 1;
        long ei = times[0] * (1L * height * (height+1))/2;
        while (si <= ei) {
            long mid = si + (ei-si)/2;
            if (isPossible(times, height, mid))
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return si;
    }
    public boolean isPossible(int[] arr, int height, long time) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int h = 0;
            while (1L * arr[i] * (1L * (h+1) * (h+2))/2 <= time) {
                h++;
            }

            height -= h;
            if (height <= 0)
                return true;
        }

        return false;
    }
}