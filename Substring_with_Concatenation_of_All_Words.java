public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(S == null || L == null || S.length() == 0 || L.length == 0) return result;
            
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(String str : L)
            if(map.containsKey(str)) map.put(str,map.get(str) + 1);
            else map.put(str,1);
        
        for(int i = 0;i < L[0].length();i++){
            
            HashMap<String,Integer> cur = new HashMap<String,Integer>();
            
            for(int j = i,left = i,count = 0;j <= S.length() - L[0].length();j += L[0].length()){
                
                String str = S.substring(j,j + L[0].length());
                
                if(!map.containsKey(str)){
                    
                    cur.clear();
                    count = 0;
                    left = j + L[0].length();
                    continue;
                }
                
                if(cur.containsKey(str)) cur.put(str,cur.get(str) + 1); 
                else cur.put(str,1);
                
                if(cur.get(str) <= map.get(str)) count++;
                else{
                    
                    while(cur.get(str) > map.get(str)){
                        count--;
                        String tmp = S.substring(left,left + L[0].length());
                        cur.put(tmp,cur.get(tmp) - 1);
                        left += L[0].length();
                    }
                    count++;
                }
                
                if(count == L.length){
                    
                    result.add(left);
                    String first = S.substring(left,left + L[0].length());
                    count--;
                    cur.put(first,cur.get(first) - 1);
                    left += L[0].length();
                    
                }
            }
        }    
        
        return result;
    }
}
