class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
    // Approach 1: Iterate 3 times ,ie, TC - O(3N) & SC - O(N)
    // Approach 2: Use the '2 Pointers', ie, TC - O(2N) & SC - O(N)

        int n = nums.length;
        int[] ans = new int[n];

        // Place the smaller & greater elements simultaneously (using 2 pointers)
        int left = 0, right = n-1;
        for (int i = 0, j = n-1; i < n; i++, j--) {
            if (nums[i] < pivot)
                ans[left++] = nums[i];
            
            if (nums[j] > pivot)
                ans[right--] = nums[j];
        } 

        while (left <= right) {
            ans[left++] = pivot;
        }

        return ans;
    }
}