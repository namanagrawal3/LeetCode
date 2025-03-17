class Solution {
    public boolean divideArray(int[] nums) {
        int[] fre = new int[501];
        for (int num : nums) {
            fre[num]++;
        }

        for (int freq : fre) {
            if (freq % 2 == 1)
                return false;
        }
        
        return true;
    }
}