class Solution {
    public long coloredCells(int n) {
      //            +4  +8  +12  +16
        // Seq --> 1,  5, 13,  25,  41, ----

        if (n == 1)
            return 1;

        n--;
        long ans = (1L * n * (8 + (n-1)*4))/2; // sum of n terms of AP (4, 8, 12, 16,---)
        return ans + 1;    
    }
}