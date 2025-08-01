class Solution {
    public int longestSubsequence(int[] arr, int difference) {
    // Variant of 'LIS'
        int n = arr.length;
        // Stores the length of subsequence ending at each element
        HashMap<Integer, Integer> dp = new HashMap<>(); 
        int maxLen = 1; 
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int currLen = 1;

            if (dp.containsKey(num - difference)) 
                currLen = dp.get(num - difference) + 1;
            
            dp.put(num, currLen);
            maxLen = Math.max(maxLen, currLen);
        }
        
        return maxLen;
    }
}