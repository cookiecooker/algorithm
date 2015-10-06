public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n1 = s1 == null ?  0 : s1.length();
        int n2 = s2 == null ?  0 : s2.length();
        int n3 = s3 == null ?  0 : s3.length();
        
        if((n1 + n2) != n3) return false;
        
        boolean[][] inter = new boolean[n1 + 1][n2 + 1];
        
        inter[0][0] = true;
        
        for(int i = 1;i <= s1.length();i++)
            inter[i][0] = inter[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
            
        for(int i = 1;i <= s2.length();i++)
            inter[0][i] = inter[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
            
        for(int i = 1;i <= s1.length();i++)
            for(int j = 1;j <= s2.length();j++)
                inter[i][j] = (inter[i-1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) 
                    || (inter[i][j-1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
        
        return inter[n1][n2];
    }
}
