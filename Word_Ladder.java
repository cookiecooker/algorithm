public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        
        LinkedList<String> word = new LinkedList<String>();
        LinkedList<Integer> num = new LinkedList<Integer>();
        
        word.add(start);
        num.add(1);
        
        while(!word.isEmpty()){
            
            String target = word.pop();
            int index = num.pop();
            
            if(target.equals(end)) return index;
            
            char[] letter = target.toCharArray();
            for(int i = 0;i < target.length();i++)
                for(char c = 'a';c <= 'z';c++){
                    
                    char tmp = letter[i];
                    
                    letter[i] = c;
                    
                    String new_word = new String(letter);
                    if(dict.contains(new_word)){
                        
                        word.add(new_word);
                        num.add(index + 1);
                        dict.remove(new_word);
                    }
                    
                    letter[i] = tmp;
                    
                }
            
        }
        
        return 0;
    }
}
