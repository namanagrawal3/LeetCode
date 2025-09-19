class Spreadsheet {
    private int[][] arr;

    public Spreadsheet(int rows) {
        arr = new int[rows][26];    
    }
    
    public void setCell(String cell, int value) {
        int r = Integer.parseInt(cell.substring(1)) - 1;
        int c = cell.charAt(0) - 'A';
        arr[r][c] = value;
    }
    
    public void resetCell(String cell) {
        int r = Integer.parseInt(cell.substring(1)) - 1;
        int c = cell.charAt(0) - 'A';
        arr[r][c] = 0;
    }
    
    public int getValue(String formula) {
        int plus = formula.indexOf('+');
        String a = formula.substring(1, plus);
        String b = formula.substring(plus+1);
        
        return valFun(a) + valFun(b);
    }
    public int valFun(String s) {
        if (s.charAt(0) >= 65 && s.charAt(0) <= 90) {
            int r = Integer.parseInt(s.substring(1)) - 1;
            int c = s.charAt(0) - 'A';
            return arr[r][c];
        }
        return Integer.parseInt(s);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */