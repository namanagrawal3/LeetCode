class Solution {
    int[][] dir = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        dfsFun(board, m, n, click[0], click[1]);
        return board;
    }
    public void dfsFun(char[][] board, int m, int n, int cr, int cc) {
        if (cr < 0 || cr >= m || cc < 0 || cc >= n || board[cr][cc] != 'E')
            return;
        
        int mineCount = 0;
        for (int i = 0; i < 8; i++) {
            int nr = cr + dir[i][0];
            int nc = cc + dir[i][1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                continue;
            if (board[nr][nc] == 'M')
                mineCount++;
        }
        
        if (mineCount != 0) {
            board[cr][cc] = (char)('0'+ mineCount);
            return;
        }
        
        board[cr][cc] = 'B';
        for (int i = 0; i < 8; i++) {
            int nr = cr + dir[i][0];
            int nc = cc + dir[i][1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                continue;
            
            dfsFun(board, m, n, nr, nc);            
        }
    }
}