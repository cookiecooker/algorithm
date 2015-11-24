public class Solution {
    public String simplifyPath(String path) {
        
        if(path == null) return null;
        else if(path.length() == 0) return "";
        
        LinkedList<String> res = new LinkedList<String>();
        
        char[] charPath = path.toCharArray();
        
        for(int i = -1;i < charPath.length;){
            
            String tmp = "/";
            
            while(((++i) < charPath.length) && (charPath[i] != '/')) tmp += charPath[i];
            
            if(tmp.equals("/.") || tmp.equals("/")) continue;
            
            if(tmp.equals("/..")){
                if(!res.isEmpty()) res.removeLast();
            }
            else res.add(tmp);
            
        }
        
        String result = "";
        
        for(String str : res) result += str;
        
        return res.isEmpty() ? "/" : result;
    }
}
