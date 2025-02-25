class Solution {
    public int numOfSubarrays(int[] arr) {
    // Similar to 'Count Subarrays sum target' (using prefix-sum with Hashmap)
    // Note : "even + ODD = odd" & "odd + ODD = even"

        int even = 1, odd = 0;          // similar to map.put(0, 1)
        int mod = 1000000007;
        long count = 0;
        int currSum = 0;

        for (int num : arr) {
            currSum += num;
            if (currSum % 2 == 0) {
                count += odd;
                even++;
            }
            else {
                count += even;
                odd++;
            }
        }

        return (int)(count % mod);  
    }
}