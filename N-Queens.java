public class Solution {
    
    int[] col;
    Boolean[] dia;
    Boolean[] dia_left;
    int num;
    ArrayList<String[]> result;

    
    
    private void search(int n){
        
        if(n == num) {
            
               String[] broad = new String[num];
                for(int i = 0;i < num;i++){
            
                   char[] string = new char[num];
            
                   for(int j = 0;j < num;j++)
                     string[j] = '.';
            
                    broad[i] = String.valueOf(string);
                }
            
                for(int i = 0;i < num;i++){
                
                    String string = broad[col[i]];
                    char[] line = string.toCharArray();
                    line[i] = 'Q';
                    broad[col[i]] = String.valueOf(line);
                }
                
               result.add(broad);
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
    
    public ArrayList<String[]> solveNQueens(int n) {
        
        col = new int[n];
        Arrays.fill(col,-1);
        dia = new Boolean[2 * n - 1];
        Arrays.fill(dia,Boolean.TRUE);
        dia_left = new Boolean[2 * n - 1];
        Arrays.fill(dia_left,Boolean.TRUE);
        result = new ArrayList<String[]>();
        num = n;
        
        search(0);
        
        return result;
    }
}
