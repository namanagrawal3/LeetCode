class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        int si = 1;
        int ei = max;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(candies, mid, k))
                si = mid + 1;
            else
                ei = mid - 1; 
        }

        return ei;
    }
    public boolean isPossible(int[] arr, int candy, long k) {
        long cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i]/candy;    
            if (cnt >= k)
                return true; 
        }

        return false;
    }
}