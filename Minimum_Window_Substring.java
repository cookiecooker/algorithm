public class Solution {
    public String minWindow(String S, String T) {
        
        if(S == null || T == null) return null;
        if(S.length() == 0 || T.length() == 0 || S.length() < T.length()) return "";
        
        int[] appeared = new int[256];
        int[] expected = new int[256];
        int start = 0,end = 0,min_start = 0,len = Integer.MAX_VALUE,appear = 0;
        
        for(int i = 0;i < T.length();i++) expected[T.charAt(i)]++;
        
        for(int i = 0;i < S.length();i++){
            
            if(expected[S.charAt(i)] > 0){
                
                appeared[S.charAt(i)]++;
                if(appeared[S.charAt(i)] <= expected[S.charAt(i)]) appear++;
            }
            
            if(appear == T.length()){
                
                while(appeared[S.charAt(start)] > expected[S.charAt(start)] || expected[S.charAt(start)] == 0){
                  
                    --appeared[S.charAt(start)];
                    start++;
                } 
                
                if(len > (i - start + 1)){
                    
                    len = i - start + 1;
                    min_start = start;
                    end = i;
                }
            }
            
        }
        
        if(len == Integer.MAX_VALUE) return "";
        else return S.substring(min_start,end + 1);
    }
}
