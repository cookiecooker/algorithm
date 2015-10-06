public class Solution {
    public boolean isMatch(String s, String p) {
        
       char[] pc = p.toCharArray();
       char[] sc = s.toCharArray();
       boolean[][] res = new boolean[pc.length + 1][sc.length + 1];
       
       res[0][0] = true;
       if(pc.length >= 1 && pc[0] == '*') res[1][0] = true;
       
       for(int i = 1;i <= pc.length;i++) 
            if(pc[i-1] == '*') res[i][0] = res[i-2][0];
       
       for(int i = 1;i <= pc.length;i++)
            for(int j = 1;j <= sc.length;j++){
            
                if((pc[i - 1] == sc[j - 1]) || (pc[i - 1] == '.')) res[i][j] = res[i - 1][j - 1];
                else if(pc[i - 1] == '*')
                    res[i][j] = (i >= 2 ? res[i-2][j] : false) || (res[i][j-1] &&  ((pc[i-2] == sc[j-1]) || (pc[i-2] == '.')));
        }
       
       return res[pc.length][sc.length];
    }
}
