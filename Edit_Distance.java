public class Solution {
    public int minDistance(String word1, String word2) {
        
        int dp_state[] = new int[word2.length() + 1];
        
        for(int i = 0;i <= word2.length();i++)//This the distance from character i of word1 to word2
            dp_state[i] = i;
            
        int upper_left;    
        
        for(int i = 0;i < word1.length();i++){
            
            upper_left = i;
            dp_state[0] = i + 1;
            
            for(int j = 1;j <= word2.length();j++){
                
                int temp = dp_state[j];
                if (word1.charAt(i) != word2.charAt(j - 1)){
                    
                    dp_state[j] = dp_state[j] > dp_state[j - 1] ? dp_state[j - 1] : dp_state[j] ;
                    dp_state[j] = dp_state[j] > upper_left ? upper_left : dp_state[j] ;
                    dp_state[j]++;
                }
                else dp_state[j] = upper_left;
                upper_left = temp;
                
            }
            
        }
        
        return dp_state[word2.length()];
    }
}
