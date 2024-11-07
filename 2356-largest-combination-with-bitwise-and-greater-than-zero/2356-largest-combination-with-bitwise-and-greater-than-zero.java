class Solution {
    public int largestCombination(int[] candidates) {
        // 2^24 > 100000
        int[] ones = new int[24];   // stores the total no. of 1s in the particular position

        for (int num : candidates) {
            int i = 0;
            while (num > 0) {
                if ((num & 1) == 1) 
                    ones[i]++;

                num = num >> 1;
                i++;
            }
        }

        int maxSize = 1;
        for (int i = 0; i < 24; i++) {
            if (ones[i] > maxSize)
                maxSize = ones[i];
        }

        return maxSize;
    }
}