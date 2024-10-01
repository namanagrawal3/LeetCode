class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] map = new int[k];
        int n = arr.length;
        
        for (int a : arr) {
            int rem = a % k;
            if (rem < 0)
                rem += k;
            map[rem]++;
        }
        
        if (map[0] % 2 == 1)       // pair is not possible
            return false;
        
        for (int i = 1; i <= k/2; i++) {
            if (map[i] != map[k-i])
                return false;
        }        
        return true;
    }
}