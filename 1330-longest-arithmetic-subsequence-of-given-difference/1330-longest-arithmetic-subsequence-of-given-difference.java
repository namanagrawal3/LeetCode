class Solution {
    public int longestSubsequence(int[] arr, int difference) {
    // Variant of 'LIS'
        int n = arr.length;
        // Stores the length of subsequence ending at each element
        HashMap<Integer, Integer> dp = new HashMap<>(); 
        int ans = 1; 
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (dp.containsKey(num - difference)) 
                dp.put(num, dp.get(num - difference) + 1);
            else 
                dp.put(num, 1);
            
            ans = Math.max(ans, dp.get(num));
        }
        
        return ans;
    }
}