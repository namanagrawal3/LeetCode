class Solution {
    public int fib(int n) {
        if (n <= 1)
            return n;
        
        int one = 0;
        int two = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = one + two;
            one = two;
            two = result;
        }

        return result;
    }
}