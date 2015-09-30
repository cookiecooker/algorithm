public class Solution {
    public boolean isNumber(String s) {
        
        boolean is = true;
        
        try{
             s = s.trim();
             Double.parseDouble(s);
             if((s.charAt(s.length() - 1) > '9' || s.charAt(s.length() - 1) < '0') && (s.charAt(s.length() - 1) != '.'))
                return false;
             
             
        }catch(NullPointerException e){
			is = false;
		}
		catch(NumberFormatException ef){
			is = false;
		}
        
        
        return is;
    }
}
