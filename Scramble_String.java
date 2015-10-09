public class Solution {
    public boolean isScramble(String s1, String s2) {
        
        
        if(s1.length() != s2.length()) return false;
        
        boolean[][][] dp = new boolean[s1.length()][s1.length()][s1.length()]; 
        
        
        for(int i = 0;i < s1.length();i++)
            for(int j = 0;j < s1.length();j++)
                dp[0][i][j] = (s1.charAt(i) == s2.charAt(j));
             
        
        for(int n = 2;n <= s1.length();n++)
            for(int i = 0;i + n <= s1.length();i++)
                for(int j = 0;j + n <= s1.length();j++)
                    for(int k = 1;k < n;k++)
                        if((dp[k-1][i][j] && dp[n-k-1][i+k][j+k]) || (dp[k-1][i][j+n-k] && dp[n-k-1][i+k][j])){ 
                            dp[n-1][i][j] = true;
                            break;
                        } 
                        
  
        
        return dp[s1.length()-1][0][0];
    }
}
