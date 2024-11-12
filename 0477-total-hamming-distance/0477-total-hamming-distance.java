class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] ones = new int[30];

        for (int n : nums) {
            int idx = 0;
            while (n > 0) {
                if ((n & 1) == 1)
                    ones[idx]++;
                n = n >> 1;
                idx++;
            }
        }

        int dist = 0;
        int n = nums.length;
        for (int one : ones) {
            dist += one * (n - one);
        }

        return dist;
    }
}