public class Solution {
    public int longestConsecutive(int[] num) {
        
        Set<Integer> record = new HashSet<Integer>();
        
        for(int i : num) record.add(i);
        
        int max = 0;
        
        for(int i : num){
            
            if(record.contains(i)){
            
                 int next = i - 1, length = 1;
                 record.remove(i);
                 while(record.contains(next)){
                
                    record.remove(next);
                    next--;
                    length++;
                }
            
                next = i + 1;
                while(record.contains(next)){
                
                    record.remove(next);
                    next++;
                    length++;
                }
            
                max = Math.max(max,length);
                
            }
        }
        
        return max;
    }
}
