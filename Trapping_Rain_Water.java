public class Solution {
    public int trap(int[] A) {
        
        int result = 0;
        int max = 0, index = 0;
        
        for(int i = 0;i < A.length;i++)
            if(A[i] > A[max]) max = i;
            
        for(int i = 0,peek = 0;i < max;i++){
            
            if(A[i] > peek) peek = A[i];
            else result += peek - A[i];
        }   
        
        for(int i = A.length - 1, top = 0;i > max;i--){
            
            if(A[i] > top) top = A[i];
            else result += top - A[i];
            
        }
        
        return result;
    }
}
