class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];

        // taking the transpose of the box
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = box[i][j];
            }
        }

        // reverse every row of the box (to get the rotated box)
        for (int i = 0; i < n; i++) {
            int left = 0, right = m-1;
            while (left < right) {
                char temp = ans[i][left];
                ans[i][left] = ans[i][right];
                ans[i][right] = temp;
                left++;
                right--;
            }
        }

        // modifying the positions of the obstacles
        for (int c = 0; c < m; c++) {
            int lastEmpty = n-1;
            for (int r = n-1; r >= 0; r--) {
                char ch = ans[r][c];
                if (ch == '.')
                    continue;
                else if (ch == '*')
                    lastEmpty = r-1;
                else if(ch == '#') {
                    ans[r][c] = '.';
                    ans[lastEmpty][c] = '#';
                    lastEmpty--;
                }       
            }
        }
        return ans;
    }
}