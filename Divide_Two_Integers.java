public class Solution {
    public int divide(int dividend, int divisor) {
        
        long dend = dividend;
        long dsor = divisor;
        dend = dend < 0 ? -dend : dend;
        dsor = dsor < 0 ? -dsor : dsor;
 
        if(dend == 0 || dend < dsor) return 0;
        
        long result = 0;
        while(dend >= dsor){
            
            long temp_dsor = dsor;
            
            for(long quiotent = 1;dend >= temp_dsor;temp_dsor <<= 1){
                
                dend -= temp_dsor;
                result += quiotent;
                quiotent <<= 1;    
            }
            
        }
        
        if((dividend ^ divisor) < 0) return -(int)result;
        else return (int)result;
    }
}
