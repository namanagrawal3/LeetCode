class Solution {
    public int minOperations(int[] nums, int k) {
        int min = 101;
        for (int num: nums) {
            min = Math.min(min, num);
        }

        if (k > min)
            return -1;

        int[] fre = new int[101];
        for (int num: nums) {
            fre[num]++;
        }

        int opr = 0;
        for (int i = 100; i >= 0; i--) {
            if (fre[i] > 0)
                opr++;
        }

        if (k == min)
            opr--;
        return opr;
    }
}