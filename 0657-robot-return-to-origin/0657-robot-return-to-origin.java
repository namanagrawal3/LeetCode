class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int cntV = 0;       // +ve --> U , -ve --> D
        int cntH = 0;       // +ve --> L , -ve --> R

        for (int i = 0; i < n; i++) {
            char ch = moves.charAt(i);
            if (ch == 'U')
                cntV++;
            else if (ch == 'D')
                cntV--;
            else if (ch == 'L')
                cntH++;
            else
                cntH--;
        }

        return cntH == 0 && cntV == 0;
    }
}