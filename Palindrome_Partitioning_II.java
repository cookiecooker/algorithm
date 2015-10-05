public class Solution {
    public int minCut(String s) {
     
     
        boolean palindrome[][] = new boolean[s.length()][s.length()]; 
        
        int dp[] = new int[s.length() + 1];// dp[j + 1]
        
        for(int i = 0;i <= s.length();i++)// the worst case is that each character is seperated
            dp[i] = s.length() - i - 1;// dp[s.length()] = -1;
        
        for(int i = s.length() - 1;i >= 0;i--){
            
            for(int j = i;j < s.length();j++){
                
                if((s.charAt(i) == s.charAt(j)) && ((j - i < 2) || (palindrome[i + 1][j - 1]))){
                    
                    palindrome[i][j] = true;
                    
                    dp[i] = dp[i] < (dp[j + 1] + 1) ? dp[i] : (dp[j + 1] + 1); 
                }
                
            }
        }
        
        return dp[0];   
    }
}
