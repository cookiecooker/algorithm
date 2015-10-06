public class Solution {
    public int candy(int[] ratings) {
        
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        int min = 0;
        
        for(int i = 1;i < ratings.length;i++)
            if(ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        
        min = candies[ratings.length - 1];
        for(int i = ratings.length - 2;i >= 0;i--){
            if((ratings[i] > ratings[i + 1]) && (candies[i] <= candies[i + 1])) 
                candies[i] = candies[i + 1] + 1;
            min += candies[i];
        }
        
        return min;
    }
}
