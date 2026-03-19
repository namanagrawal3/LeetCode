class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                int rem = n % 10;
                sum += rem * rem;
                n /= 10;
            }
            n = sum;
            if (set.contains(n))
                return false;
            set.add(n);
        }

        return n == 1;
    }
}