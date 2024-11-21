class Solution {
    public int minCut(String s) {
        int n = s.length();            

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return partitionFun(s, 0, n-1, dp);
    }
    public int partitionFun(String s, int i, int j, int[] dp) {
        if (isPalindrome(s, i, j))
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int minCuts = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
    /* 
        Instead of writing : "temp = solve(s, i, k, dp) + 1 + solve(s, k+1, j, dp)"
        We will recurse for only right part when left part turns out to be palindrome
				
	    Reason : If left substring becomes palindrome then there is no need to partition
        it further (which in turn reduces the number of recursive calls)                
    */
            if (isPalindrome(s, i, k)) {
                int temp =  1 + partitionFun(s, k+1, j, dp);            
                minCuts = Math.min(minCuts, temp);
            } 
        }

        return dp[i] = minCuts;
    }
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }
}