class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (1L*m*k > n)
            return -1;

        int minDay = bloomDay[0];
        int maxDay = bloomDay[0];
        for (int i = 1; i < n; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }

        int si = minDay;
        int ei = maxDay;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(mid, bloomDay, m, k))
                ei = mid - 1;
            else
                si = mid + 1; 
        }

        return si; 
    }
    public boolean isPossible(int limit, int[] day, int m, int k) {
        int n = day.length;
        int cnt = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (day[j] > limit)
                i = j+1;
            
            if (j-i+1 == k) {
                cnt++;
                i = j+1;
            }

            if (cnt == m)
                return true;
            j++;
        }

        return false;
    }
}