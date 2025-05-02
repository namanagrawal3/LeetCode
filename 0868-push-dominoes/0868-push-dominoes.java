class Solution {
    public String pushDominoes(String dominoes) {
    // For each "." we will find the "leftClosestR" & "rightClosestL"
    // and will check which one will have more impact (based on the distance)
    // i.e,                     --> .   <--
        int n = dominoes.length();
        int[] leftClosestR = new int[n];
        int[] rightClosestL = new int[n];

        leftClosestR[0] = (dominoes.charAt(0) == '.' || dominoes.charAt(0) == 'L') ? -1 : 0;
        for (int i = 1; i < n; i++) {
            char ch = dominoes.charAt(i);
            if (ch == '.')
                leftClosestR[i] = leftClosestR[i-1];
            else if (ch == 'L')
                leftClosestR[i] = -1;
            else
                leftClosestR[i] = i;
        }

        rightClosestL[n-1] = (dominoes.charAt(n-1) == '.' || dominoes.charAt(n-1) == 'R') ? -1 : n-1;
        for (int i = n-2; i >= 0; i--) {
            char ch = dominoes.charAt(i);
            if (ch == '.')
                rightClosestL[i] = rightClosestL[i+1];
            else if (ch == 'R')
                rightClosestL[i] = -1;
            else
                rightClosestL[i] = i;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (leftClosestR[i] == -1 && rightClosestL[i] == -1)
                ans.append('.');
            else if (leftClosestR[i] == -1)
                ans.append('L');
            else if (rightClosestL[i] == -1)
                ans.append('R');
            else {
                int leftDist = i - leftClosestR[i];
                int rightDist = rightClosestL[i] - i;
                
                if (leftDist == rightDist)
                    ans.append('.');
                else if (leftDist > rightDist)
                    ans.append('L');
                else
                    ans.append('R');
            }
        }

        return ans.toString();    
    }
}