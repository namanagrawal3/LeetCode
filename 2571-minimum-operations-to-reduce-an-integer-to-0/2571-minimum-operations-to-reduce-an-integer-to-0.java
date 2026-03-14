class Solution {
    public int minOperations(int n) {
        // Perform operations greedily to remove the continuous 1s
         
        int opr = 0;
        while (n > 0) {
            // case1: last two bits are '11' (means continuous 1s)
            if ((n & 3) == 3) {     
                n++;                // Add 1 to n to cancel continuous 1s
                opr++;
            }
            // case2: last bit is '1' 
            else if ((n & 1) == 1) {
                n--;                // Subtract 1 from n to cancel last 1
                opr++;
            }
            // case3: last bit is '0'
            else {
                n >>= 1;            // Simply remove it (divide by 2)
            }
        }

        return opr;
    }
}