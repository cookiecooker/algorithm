public class Solution {
    
    int[] col;
    Boolean[] dia;
    Boolean[] dia_left;
    int num;
    int result = 0;
    
    
    private void search(int n){
        
        if(n == num) {
           
            result++;
            return;
        }
        
        
        for(int i = 0;i < num;i++){
         
            if(col[i] == -1 && dia[num + i - n - 1] == true && dia_left[n + i] == true){
                
                col[i] = n;
                dia[num + i - n - 1] = false;
                dia_left[n + i] = false;
            
                search(n+1);
            
                col[i] = -1;
                dia[num + i - n - 1] = true;
                dia_left[n + i] = true;
            }
        }
        
    }
    
    public int totalNQueens(int n) {
        
        col = new int[n];
        Arrays.fill(col,-1);
        dia = new Boolean[2 * n - 1];
        Arrays.fill(dia,Boolean.TRUE);
        dia_left = new Boolean[2 * n - 1];
        Arrays.fill(dia_left,Boolean.TRUE);
        num = n;
        
        search(0);
        
        return result;
        
    }
}
