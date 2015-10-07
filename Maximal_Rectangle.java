public class Solution {
    public int maximalRectangle(char[][] matrix) {
        
         if(matrix.length == 0) return 0;
         int max = 0;
         
         int[] left = new int[matrix[0].length];
         int[] right = new int[matrix[0].length];
         int[] height = new int[matrix[0].length];
         
         Arrays.fill(right,matrix[0].length);
         
         for(int i = 0;i < matrix.length;i++){
             
             int lb = 0, rb = matrix[i].length;
             
             for(int j = 0;j < matrix[i].length;j++){
                 
                 if(matrix[i][j] == '1'){
                    
                     ++height[j];
                     left[j] = Math.max(left[j],lb);
                 }else{
                     
                     height[j] = 0;
                     right[j] = matrix[i].length;
                     left[j] = 0;
                     lb = j + 1;
                 }
             }
             
             for(int j = matrix[i].length - 1;j >= 0;j--){
              
                if(matrix[i][j] == '1'){
                    
                    right[j] = Math.min(right[j],rb);
                    max = Math.max(max,height[j] * (right[j] - left[j]));
                    
                }else{
                    
                    rb = j;
                }   
                
             }
             
         }
         
         return max;
    }
}
