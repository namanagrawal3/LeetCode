class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        for (int i = 0; i < n-1; i++) {
            int j = n-1;
            while (j > i) {
                if (colors[i] != colors[j]) {
                    maxDist = Math.max(maxDist, j-i);
                    break;
                }
                else 
                    j--;
            }
        }

        return maxDist;
    }
}