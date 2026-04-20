class Solution {
    public int maxDistance(int[] colors) {
    // Check the distance of each House with First & Last House only (for max distance)
        int n = colors.length;
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[0])
                maxDist = Math.max(maxDist, i);
            
            if (colors[i] != colors[n-1])
                maxDist = Math.max(maxDist, n-1-i);
        }

        return maxDist;
    }
}