class Solution {
    public int maxArea(int[] height) {
        int n = height.length;            
        int left = 0;
        int right = n-1;
        int maxWater = 0;
        
        while (left < right) {
            int l = Math.min(height[left], height[right]);
            int b = right - left;

            maxWater = Math.max(maxWater, l*b);
            
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        
        return maxWater;
    }
}