class Solution {
    public long minimumDifference(int[] nums) {
    // Use 'Prefix-Suffix' Approach (Use Heaps to find the sum efficiently)
        int t = nums.length;
        int n = t/3;

        // SUM (first) - min
        long[] leftMin = new long[t];
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());  // Left max-Heap
        leftMin[0] = nums[0];
        left.add(nums[0]);

        for (int i = 1; i < n; i++) {
            leftMin[i] = leftMin[i-1] + nums[i];
            left.add(nums[i]);
        }

        for (int i = n; i < 2*n; i++) {
            left.add(nums[i]);
            leftMin[i] = leftMin[i-1] + nums[i] - left.poll();
        }

        // SUM (second) - max
        long[] rightMax = new long[t];
        PriorityQueue<Integer> right = new PriorityQueue<>();  // Right min-Heap
        rightMax[t-1] = nums[t-1];
        right.add(nums[t-1]);

        for (int i = t-2; i >= t-n; i--) {
            rightMax[i] = rightMax[i+1] + nums[i];
            right.add(nums[i]);
        }

        for (int i = t-n-1; i >= n; i--) {
            right.add(nums[i]);
            rightMax[i] = rightMax[i+1] + nums[i] - right.poll();
        }

        // checking for each pair of index
        long ans = Long.MAX_VALUE;
        for (int i = n-1; i < 2*n; i++) {
            long diff = leftMin[i] - rightMax[i+1];
            ans = Math.min(ans, diff);
        }

        return ans;
    }
}