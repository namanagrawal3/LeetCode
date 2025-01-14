class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    cnt++;
                    
                    if (i+1 < m && board[i+1][j] == 'X')        // vertical region
                        dfsVer(board, m, i, j);
                    if (j+1 < n && board[i][j+1] == 'X')        // horizontal region
                        dfsHor(board, n, i, j);
                }
            }
        }

        return cnt;
    }
    public static void dfsVer(char[][] board, int m, int cr, int cc) {
        if (cr == m || board[cr][cc] == '.')
            return;
        
        board[cr][cc] = '.';
        dfsVer(board, m, cr+1, cc);                
    }
    public static void dfsHor(char[][] board, int n, int cr, int cc) {
        if (cc == n || board[cr][cc] == '.')
            return;

        board[cr][cc] = '.';
        dfsHor(board, n, cr, cc+1);
    }
}