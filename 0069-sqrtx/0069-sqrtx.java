class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;

        long si = 0;
        long ei = x/2;        
        while (si <= ei) {
            long mid = si + (ei-si)/2;
            if (mid * mid <= x)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return (int)ei;
    }
}