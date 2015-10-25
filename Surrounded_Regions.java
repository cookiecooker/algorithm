public class Solution {
    public void solve(char[][] board) {
        
        if(board == null || board.length == 0) return;
        
        for(int i = 0;i < board.length;i++){
         
            fill(board,i,0);
            fill(board,i,board[0].length - 1);
        }
        
        for(int i = 0;i < board[0].length;i++){
            
            fill(board,0,i);
            fill(board,board.length - 1,i);
        }
        
        for(int i = 0;i < board.length;i++)
            for(int j = 0;j < board[0].length;j++)
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
        
    }
    
    private boolean judge(char[][] board,int i,int j){
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return false;
        
        board[i][j] = '#';
        
        return true;
    }
    
    private void fill(char[][] board,int i,int j){
        
        if(!judge(board,i,j)) return;
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(i * board[0].length + j);
        
        while(!queue.isEmpty()){
            
            int here = queue.poll();
            int x = here  / board[0].length;
            int y = here % board[0].length;
          
            if(judge(board,x - 1,y))  queue.add((x - 1) * board[0].length + y);
            if(judge(board,x + 1,y))  queue.add((x + 1) * board[0].length + y);
            if(judge(board,x,y - 1))  queue.add(x * board[0].length + (y - 1));
            if(judge(board,x,y + 1))  queue.add(x * board[0].length + (y + 1));
              
            
        }
    }
}
