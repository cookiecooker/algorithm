public class Solution {
    public int search(int[] A, int target) {
        
        int first = 0,last = A.length;
        
        while(first < last){
            
            int mid = (first + last) / 2;
            
            if(A[mid] == target) return mid;
            else if(A[first] < A[mid]){
                
                if(A[first] <= target && target < A[mid]) last = mid;
                else first = mid + 1;
            }else{
                
                if(A[mid] < target && target <= A[last - 1]) first = mid + 1;
                else last = mid;
            }
        }
        
        return -1;
    }
}
