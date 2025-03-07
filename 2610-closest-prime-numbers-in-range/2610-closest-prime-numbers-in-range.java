class Solution {
    public int[] closestPrimes(int left, int right) {
    // First, find all the prime no. using 'Prime Seive'
    // then check for the difference between each pair 
    
        boolean[] isPrime = new boolean[right+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i*i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        int i = right-1, j = right;
        int num1 = -1, num2 = -1;
        while (i >= left && j >= left) {
            while (j >= left && !isPrime[j]) {
                j--;
            }

            i = j-1;
            while (i >= left && !isPrime[i]) {
                i--;
            }

            if (i < left)
                break;
            if (j-i <= minDiff) {
                minDiff = j-i;
                num2 = j;
                num1 = i;
            }
            j = i;
        }

        return new int[] {num1, num2};
    }
}