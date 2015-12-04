public class NumMatrix {

    private int[][] accu;

    public NumMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        accu = new int[m+1][n+1];
        
        for(int i = 1;i <= m;i++)
            for(int j = 1;j <= n;j++)
                accu[i][j] = accu[i-1][j] + accu[i][j-1] - accu[i-1][j-1] + matrix[i-1][j-1]; 
        
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return accu[row2 + 1][col2 + 1] - accu[row2 + 1][col1] - accu[row1][col2+1] + accu[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
