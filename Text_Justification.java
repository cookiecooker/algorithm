public class Solution {
    
    private String space(int index,int num,int space_len,boolean last){
        
        if(index > num || space_len < 1) return "";
        
        StringBuffer string = new StringBuffer();
        
        int mod = space_len % num;
        
        int space_num = last ? 1 : ( (space_len / num) +  (index <= mod ? 1 : 0) ) ;
        
        while((space_num--) > 0) string.append(" ");
        
        return string.toString();
    }
    
    private String form_line(String[] words,int start,int end,int L,int word_len,boolean last){
        
        StringBuffer string = new StringBuffer();
        
        int num = end - start;
        int space_len = L - word_len;
        
        for(int i = start;i <= end;i++){
            
            string.append(words[i]);
            string.append(space(i - start + 1,num,space_len,last));
        }
        
        int space_num = L - string.length();
        
        while((space_num--) > 0) string.append(" ");
        
        return string.toString();
    }

    
    public ArrayList<String> fullJustify(String[] words, int L) {
        
        ArrayList<String> result = new ArrayList<String>();
        
        int len = 0, start = 0;
        for(int i = 0;i < words.length;i++){
            
            if(len + words[i].length() + i - start > L){
                
                result.add(form_line(words,start,i - 1,L,len,false));
                len = 0;
                start = i;
            }
            
            len += words[i].length();
        }
        result.add(form_line(words,start,words.length - 1,L,len,true));
        
        return result; 
    }
}
