class Solution {
    public int minimumMountainRemovals(int[] nums) {
        // Mountain Array : LIS --> idx <-- LDS
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for (int i = 1; i < n; i++) {                  // filling lis array
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i])
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }

        for (int i = n-2; i >= 0; i--) {               // filling lds array
            for (int j = i+1; j < n; j++) {
                if (nums[j] < nums[i])
                    lds[i] = Math.max(lds[i], lds[j]+1);
            }
        }

        int minRemoval = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                int left = i+1 - lis[i];
                int right = n-i - lds[i];
                minRemoval = Math.min(minRemoval, left+right);
            }
        }

        return minRemoval;   
    }
}