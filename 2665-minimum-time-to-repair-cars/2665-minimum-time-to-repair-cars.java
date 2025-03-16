class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long si = 1;
        long ei = 1L * ranks[ranks.length-1] * cars * cars;

        while (si <= ei) {
            long mid = si + (ei-si)/2;
            if (isPossible(mid, ranks, cars)) 
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return si;
    }
    public boolean isPossible(long minute, int[] ranks, int cars) {
        int cnt = 0;
        for (int r : ranks) {
            cnt += (int) Math.sqrt(minute/r);

            if (cnt >= cars)
                return true;
        }
        return false;
    }
}