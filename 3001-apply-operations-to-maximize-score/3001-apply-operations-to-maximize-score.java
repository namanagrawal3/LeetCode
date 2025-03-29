class Solution {
    int mod = 1000000007;
    
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] ps = findPrimeScores(nums);  // stores the Prime-Scores

        Stack<Integer> st = new Stack<>();
        int[] ngr = new int[n];            // next greater element to right
        int[] pgel = new int[n];           // previous greater-equal to left

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && ps[i] >= ps[st.peek()]) {
                st.pop();
            }

            ngr[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && ps[i] > ps[st.peek()]) {
                st.pop();
            }
            
            pgel[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long[] subarrays = new long[n];
        for (int i = 0; i < n; i++) {
            subarrays[i] = 1L * (i-pgel[i]) * (ngr[i]-i);
        }

        int[][] sortedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedNums[i][0] = i;
            sortedNums[i][1] = nums.get(i);
        }

        Arrays.sort(sortedNums, new Comparator<int[]>() {  // Decreasing Order
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        long score = 1;
        int i = 0;                      // start with the largest element greedily
        while (i < n && k > 0) {
            int x = sortedNums[i][1];
            int idx = sortedNums[i][0];

            long opr = Math.min(k, subarrays[idx]);
            score = (score * powFun(x, opr)) % mod;
            k -= opr;

            i++;
        }

        return (int)score;
    }
    public long powFun(long x, long n) {
        if (n == 0)
            return 1;
        
        long ans = powFun(x, n/2) % mod;
        ans = (ans * ans) % mod;
        if (n % 2 == 1)
            ans = (ans * x) % mod;

        return ans; 
    }
    public int[] findPrimeScores(List<Integer> nums) {
        int n = nums.size();
        int max = nums.get(0);
        for (int i = 0; i < n; i++) {         // finding the prime no upto max 
            max = Math.max(max, nums.get(i));
        }

        boolean[] isPrime = new boolean[max+1];      
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i*i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        int[] primeScores = new int[n];         // calculating the prime-scores
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            for (int prime : primes) {
                if (prime * prime > num)
                    break;

                if (num % prime != 0)
                    continue;

                primeScores[i]++;
                while (num % prime == 0) {
                    num = num / prime;
                }
            }

            if (num > 1)
                primeScores[i]++;
        }

        return primeScores;
    }
}