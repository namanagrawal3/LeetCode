class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int mincolor = Integer.MAX_VALUE;
        int cntW = 0;
        
        int si = 0, ei = 0;
        while (ei < n) {
            char ch = blocks.charAt(ei);
            if (ch == 'W')
                cntW++;

            if (ei-si+1 == k) {
                mincolor = Math.min(mincolor, cntW);
                if (blocks.charAt(si) == 'W')
                    cntW--;
                si++;
            }

            ei++;
        }
        
        return mincolor;
    }
}