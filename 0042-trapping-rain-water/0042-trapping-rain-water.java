class Solution {
    public int trap(int[] height) {
        // Approach 1 : Find the left & right max using the 2 loops (TC - O(n2))
        // Approach 2 : Using the Prefix & Suffix array to find max (TC - O(n), SC - O(2n))
        // Approach 3 : Similar to Approach 2 - only Suffix array (TC - O(n), SC - O(n))
        // Approach 4 : Using the '2 Pointers' (TC - O(n))

        int left = 0;
        int right = height.length - 1;

        int ans = 0;
        int lMax = -1;
        int rMax = -1;

        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            if (lMax < rMax) {
                ans += lMax - height[left];
                left++;
            }
            else {
                ans += rMax - height[right];
                right--;
            }
        }

        return ans; 
    }
}