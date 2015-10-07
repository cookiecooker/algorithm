public class Solution {
    
    private boolean valid(char[][] board, int x , int y, int v){
        
        int r = 3 * (x / 3), c = 3 * (y / 3);
        for(int i = 0;i < 9;i++){
            
            if(board[x][i] - '0' == v) return false;
            if(board[i][y] - '0' == v) return false;
            
            int row = r + i % 3;
            int col = c + i / 3;
            
            if(board[row][col] - '0' == v) return false;
        }
        
        return true;
    }
    
    private boolean search(char[][] board, ArrayList<Integer> space, int cur, int len){
        
        if(cur == len) return true;
        
        int index = space.get(cur);
        int x = index / 9;
        int y = index % 9;
        
        for(int k = 1;k <= 9;k++){
            
            if(valid(board,x,y,k)){
                
                board[x][y] = (char)('0' + k);
                
                if(search(board,space,cur + 1,len)) return true;
                
                board[x][y] = '.';
            }
            
        }
        
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        
        ArrayList<Integer> space = new ArrayList<Integer>();
        
        for(int i = 0;i < 9;i++)
            for(int j = 0;j < 9;j++)
                if(board[i][j] == '.') space.add(i * 9 + j);
                
        search(board,space,0,space.size());
    }
}
