class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        long N = n; 
        if (N < 0){
            N = -N;
            x = 1/x;
        }

        double ans = myPow(x, (int)(N/2));
        ans = ans * ans;
        if (N % 2 != 0)
            ans = ans * x;

        return ans;  
    }
}