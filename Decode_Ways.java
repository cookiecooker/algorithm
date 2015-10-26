public class Solution {
    public int numDecodings(String s) {
     
        if(s == null || s.length() == 0) return 0;
        
        int cur = 1, pre = 0;
        for(int i = 0;i<s.length();i++){
            
            if(s.charAt(i) == '0') cur = 0;
            
            if(i < 1 || !((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))) pre = 0;
            
            int tmp = cur;
            cur = pre + cur;
            pre = tmp;
        }
        
        return cur;
    }
}
