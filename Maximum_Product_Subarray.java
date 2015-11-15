public class Solution {
    public int maxProduct(int[] A) {
        
       int max_end = A[0];
       int max_here = A[0];
       int min_here = A[0];
      
       for(int i = 1;i < A.length;i++){
           
           int temp_max = A[i] * max_here;
           int temp_min = A[i] * min_here;
           
           max_here = Math.max(A[i],Math.max(temp_max,temp_min));
           min_here = Math.min(A[i],Math.min(temp_max,temp_min));
           
           max_end = Math.max(max_end,max_here);
       }
       
       return max_end;
    }
}
