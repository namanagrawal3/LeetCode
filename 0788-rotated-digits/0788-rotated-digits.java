class Solution {
    public int rotatedDigits(int n) {
    // Integer containing digits 'only (0, 1 & 8)' or 'any of digit (3, 4 & 7)' is invalid 

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i))
                cnt++;
        }
        return cnt;
    }
    public boolean isGood(int n) {
        boolean flag = false;
        while (n > 0) {
            int digit = n % 10;

            if (digit == 3 || digit == 4 || digit == 7)
                return false;
            
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9)
                flag = true;

            n /= 10;
        }
        return flag;
    }
}