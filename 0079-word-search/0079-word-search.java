class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {
                    boolean ans = checkFun(board, m, n, i, j, word, 0);
                    if (ans)
                        return true;
                }
            }
        }
        return false;
    }
    public boolean checkFun(char[][] board, int m, int n, int cr, int cc, String word, int idx) {
        if (idx == word.length())
            return true;
            
        if (cr < 0 || cr >= m || cc < 0 || cc >= n || board[cr][cc] != word.charAt(idx))
            return false;

        board[cr][cc] = '*';            // marking as visited

        for (int i = 0; i < 4; i++) {
            boolean ans = checkFun(board, m, n, cr + dir[i][0], cc + dir[i][1], word, idx+1);
            if (ans)
                return true;
        }

        board[cr][cc] = word.charAt(idx);
        return false;  
    }
}