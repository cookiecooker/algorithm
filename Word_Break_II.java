public class Solution {
    
    private void sequence(String s, ArrayList<String> result, boolean[][] seg, ArrayList<String> word, int len){
        
        if(len < 0){
            StringBuffer str = new StringBuffer();
            for(int i = word.size() - 1;i >= 0;i--)    str.append(word.get(i) + " ");
            result.add(str.toString().trim());
            return;
        }
        
        for(int i = 0;i < s.length();i++)
           /* if(seg[len][i]){
            
                word.add(s.substring(i,len));
                sequence(s,result,seg,word,i);
                word.remove(word.size() - 1);
            }*/
            if(seg[i][len]){
            
                word.add(s.substring(i,len+1));
                sequence(s,result,seg,word,i-1);
                word.remove(word.size() - 1);
            }
    }
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        
        ArrayList<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0 || dict == null || dict.size() == 0) return result;
     //   boolean[][] seg = new boolean[s.length() + 1][s.length()];
        boolean[][] seg = new boolean[s.length()][s.length()];
        
      /*  for(int i = 1;i <= s.length();i++)
            for(int j = i-1;j >= 0;j--)
                if(dict.contains(s.substring(j,i))) seg[i][j] = true;*/
                
          for(int i = 0;i < s.length();i++)  
            for(int j = i;j < s.length();j++)
                if(dict.contains(s.substring(i,j+1))) seg[i][j] = true;
                
        ArrayList<String> seq = new ArrayList<String>(); 
        sequence(s,result,seg,seq,s.length()-1);
        return result;
    }
}
