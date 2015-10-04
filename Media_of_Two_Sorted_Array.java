public class Solution {
    
    public double findMedianSortedArrays(int A[], int B[]) {
        
        int mid = (A.length + B.length) / 2;
        
        if((A.length + B.length) % 2 == 0) return (find(A,B,mid) + find(A,B,mid-1)) * 0.5;
        else return find(A,B,mid);
    }
    
    private double find(int A[], int B[], int k){
        
        int ast = 0, bst = 0;
        int amid,bmid,aed = A.length,bed = B.length;
        while(true){
            
            int alen = aed - ast;
            int blen = bed - bst;
            
            if(ast == aed) return B[bst + k];
            if(bst == bed) return A[ast + k];
            if(k == 0) return Math.min(A[ast],B[bst]);
            
           
                 amid = alen * k / (alen + blen);

                bmid = k - amid - 1;
        
                 amid += ast;
                 bmid += bst;
           
            
            if(A[amid] > B[bmid]){
                
                k -= bmid - bst + 1;
                bst = bmid + 1;
                aed = amid + 1;
            }else{
                
                k -= amid - ast + 1;
                ast = amid + 1;
                bed = bmid + 1;
            }
        }
    }
}
