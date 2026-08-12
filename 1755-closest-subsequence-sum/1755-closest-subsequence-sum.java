class Solution {
    public int minAbsDifference(int[] nums, int goal) {
    // We can't use the 'Recursion' to generate all subsets ,ie, TLE --> O(2^n)
    // We even can't use the 'DP' top-down/bottom-up ,ie, TLE --> O(n*goal)
    // Check the constraints and see we can use 'Meet In The Middle' technique

        int n = nums.length;
        int n1 = n/2;
        int n2 = n - n1;

        int[] sumA = new int[1<<n1];   // stores the subset sum of first(A) & second half(B)
        int[] sumB = new int[1<<n2];

        fillSubsetSum(sumA, n1, nums, 0);
        fillSubsetSum(sumB, n2, nums, n1);

        Arrays.sort(sumB);
        
        int minDiff = Integer.MAX_VALUE;
        for (int sum: sumA) {
            int req = goal - sum;
            int diff = findSmallDiff(sumB, req, sum, goal);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
    public void fillSubsetSum(int[] sumArr, int n, int[] arr, int si) {
        for (int mask = 0; mask < (1<<n); mask++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1<<i)) != 0)
                    sum += arr[i+si];
            }
            sumArr[mask] = sum;
        }
    }
    public int findSmallDiff(int[] sumArr, int target, int sumA, int goal) {
    // Find the 'lower-bound' of the target & its 'prev' and return the min diff
        int n = sumArr.length;
        int si = 0, ei = n-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (sumArr[mid] >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }

        // 'si' now points to the 'lower-bound' of target, ie, just >= target
        if (si == 0)
            return Math.abs(sumA + sumArr[si] - goal);
        else if (si == n)
            return Math.abs(sumA + sumArr[si-1] - goal);
        return Math.min(Math.abs(sumA + sumArr[si] - goal), Math.abs(sumA + sumArr[si-1] - goal));
    }
}