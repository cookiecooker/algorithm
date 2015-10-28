public class Solution {
    public String reverseWords(String s) {
        
        if(s == null) return null;
        
        s = s.trim();
        if(s.length() == 0) return "";
        
        StringBuffer string = new StringBuffer();
        
        int len = 0;
        for(int i = s.length() - 1;i >= 0;i--){
            
            if((s.charAt(i) == ' ') && (len == 0)) continue;
            
            else if(s.charAt(i) == ' '){
                
                string.append(s.substring(i + 1,i + len + 1) + " ");
                len = 0;
            }
            else len++;
            
        }
        string.append(s.substring(0,len));
    
        return string.toString().trim();    
    }
}
