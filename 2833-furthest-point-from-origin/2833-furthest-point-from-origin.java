class Solution {
    public int furthestDistanceFromOrigin(String moves) {
    // L & R will cancel each other, thus abs(L-R) + cnt(_) will be ans
    
        int n = moves.length();
        int cnt = 0;        // +ve --> L , -ve --> R
        int cnt_ = 0;

        for (int i = 0; i < n; i++) {
            char ch = moves.charAt(i);
            if (ch == 'L')
                cnt++;
            else if (ch == 'R')
                cnt--;
            else 
                cnt_++;
        }

        return Math.abs(cnt) + cnt_;
    }
}