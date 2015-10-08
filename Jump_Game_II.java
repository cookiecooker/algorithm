public class Solution {
    public int jump(int[] A) {
        
       int result = 0,last = 0,cur = 0;
       
       for(int i = 0;i < A.length;i++){
           
           if(i > last){
               ++result;
               last = cur;
           }
           cur = Math.max(cur,i+A[i]);
       }
       
       return result;
    }
}
