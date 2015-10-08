public class Solution {
    public int maxProfit(int[] prices) {
        
        int[] global = new int[3];
        int[] local = new int[3];
        
        for(int i = 0;i < prices.length - 1;i++){
            
            int diff = prices[i + 1] - prices[i];
            for(int j = 2;j > 0;j--){
                
                local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0),local[j] + diff);
                global[j] = Math.max(global[j],local[j]);
            }
        }
        
        
        return global[2];
    }
}
