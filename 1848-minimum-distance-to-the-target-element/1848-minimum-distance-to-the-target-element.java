class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        // For minimised distance, move towards left and right of 'start' position
        if (nums[start] == target)
            return 0;

        int n = nums.length;
        int minDist = n;

        for (int i = start-1; i >= 0; i--) {
            if (nums[i] == target) {
                minDist = Math.min(minDist, start-i);
                break;
            }
        }

        for (int i = start+1; i < n; i++) {
            if (nums[i] == target) {
                minDist = Math.min(minDist, i-start);
                break;
            }
        }

        return minDist;
    }
}