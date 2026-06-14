class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxOnes = 0;
        int currOnes = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                currOnes++;
            else {
                maxOnes = Math.max(maxOnes, currOnes);
                currOnes = 0;
            }
        } 

        maxOnes = Math.max(maxOnes, currOnes);
        return maxOnes;
    }
}