class Solution {
    public int addRungs(int[] rungs, int dist) {
        int n = rungs.length;
        int extra = (rungs[0] <= dist) ? 0 : ((rungs[0] % dist == 0) ? rungs[0]/dist-1 : rungs[0]/dist);

        for (int i = 0; i < n-1; i++) {
            int space = rungs[i+1] - rungs[i];
            if (space > dist)
                extra += (space % dist == 0) ? space/dist-1 : space/dist;
        }

        return extra;
    }
}