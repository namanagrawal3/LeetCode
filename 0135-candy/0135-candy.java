class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1)
            return 1;
        
        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            candy[i] = 1;
        }
        for (int i = 1; i < n; i++) {            // when moving forward and comparing left side
            if (ratings[i] > ratings[i-1])
                candy[i] = candy[i-1] + 1;
        }
        
        int[] candy2 = new int[n];
        for (int i = 0; i < n; i++) {
            candy2[i] = 1;
        }
        for (int i = n-2; i >= 0; i--) {         // when moving backward and comparing right side
            if (ratings[i] > ratings[i+1])
                candy2[i] = candy2[i+1] + 1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(candy[i], candy2[i]);
        }
        return sum;
    }
}