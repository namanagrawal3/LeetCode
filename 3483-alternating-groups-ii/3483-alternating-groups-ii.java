class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int n = colors.length;

        int si = 0, ei = 1;
        for (; ei < n+k-1; ei++) {
            if (colors[ei % n] == colors[(ei-1) % n]) {
                int len = ei-1 - si + 1;
                if (len >= k)
                    count += len - k + 1;
                si = ei;
            }
        }

        int len = ei-1 - si + 1;
        if (len >= k)
            count += len - k + 1;
            
        return count;
    }
}