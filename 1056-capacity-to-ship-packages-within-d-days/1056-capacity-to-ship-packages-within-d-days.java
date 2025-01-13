class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = weights[0];
        int max = weights[0];
        for (int i = 1; i < n; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        int si = max;
        int ei = sum;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(mid, weights, days))
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return si;
    }
    public boolean isPossible(int limit, int[] weights, int days) {
        int cnt = 1;
        int currWt = 0;
        for (int i = 0; i < weights.length; i++) {
            if (currWt + weights[i] <= limit) 
                currWt += weights[i];
            else {
                cnt++;
                currWt = weights[i]; 
            }

            if (cnt > days)
                return false;
        }
        
        return true;
    }
}