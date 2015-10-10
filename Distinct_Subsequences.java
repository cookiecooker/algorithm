public class Solution {
    public int numDistinct(String S, String T) {
        
        int[] dp = new int[T.length() + 1];
        dp[0] = 1;
        
        for(int i = 0;i < S.length();i++)
            for(int j = T.length() - 1;j >= 0;j--)
                dp[j + 1] += S.charAt(i) == T.charAt(j) ? dp[j] : 0;
            
        return dp[T.length()];    
        
    }
}
