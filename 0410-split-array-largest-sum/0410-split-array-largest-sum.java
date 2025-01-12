class Solution {
    public int splitArray(int[] arr, int k) {
        // same as "Painter's Partition" & "Book Allocation" problems

        int n = arr.length;
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        
        int si = max;
        int ei = sum;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(mid, arr, k))
                ei = mid - 1;
            else
                si = mid + 1;
        }
        
        return si;
    }
    public boolean isPossible(int max, int[] arr, int k) {
        int currSum = 0;
        int i = 0;
        int cnt = 1;
        while (i < arr.length) {
            if (currSum + arr[i] <= max) {
                currSum += arr[i];
                i++;
            }
            else {
                currSum = 0;
                cnt++;
            }
            
            if (cnt > k)
                return false;
        }        
        return true;
    }
}