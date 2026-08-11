class Solution {
    public int missingInteger(int[] nums) {
    // Approach 1: Find the sum of longest seq pref & check using a HashSet
    
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int n = nums.length;
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i-1] + 1)
                break;
            sum += nums[i];
        }

        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}