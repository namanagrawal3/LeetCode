class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // (x-y) % k == 0
        // x % k == y % k

        int[] rem = new int[k];   // We can also use the HashMap to keep the trak of rem
        rem[0] = 1;
        int cnt = 0;
        long sum = 0;
        
        for (int a: nums) {
            sum += a;
            int r = (int)(sum % k);
            if (r < 0)
                r += k;
                
            cnt += rem[r];
            rem[r]++;
        }
        
        return cnt;
    }
}