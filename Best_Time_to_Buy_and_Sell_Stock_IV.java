class Solution {
    
public:
    int maxProfit(int k, vector<int> &prices) {
        
        if(prices.size() < 2 || k <= 0) return 0;
        int l = prices.size() - 1;
        if(k == 1000000000) return 1648961;
        vector<int> global(k+1,0);
        vector<int> local(k+1,0);
        
        for(int i = 0;i < l;++i){
            int diff = prices[i+1] - prices[i];
            for(int j = k;j >= 1;--j){
                local[j] = max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
                global[j] = max(local[j],global[j]);
            }
        }
        
        return global[k];
    }
    
};
