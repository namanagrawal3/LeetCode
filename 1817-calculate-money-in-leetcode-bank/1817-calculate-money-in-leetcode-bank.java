class Solution {
    public int totalMoney(int n) {
        int div = n / 7;
        int rem = n % 7;

        int sum = 0;
        int val = 7;
        int sub = 0;

        for (int i = 0; i < div; i++) {
            sum += val * (val+1) / 2;
            sum -= sub * (sub+1) / 2;
            val++;
            sub++;
        }

        int temp = div + rem;
        sum += temp * (temp+1) / 2;
        sum -= sub * (sub+1) / 2;

        return sum;
    }
}