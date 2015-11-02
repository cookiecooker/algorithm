public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(num.length < 3) return result;
        
        Arrays.sort(num);
        
        for(int i = 0;i < num.length - 2;i++){
            
            if(i > 0 && num[i] == num[i - 1]) continue;
            
            int start = i + 1, end = num.length - 1;
            
            while(start < end){
                
                int sum = num[start] + num[end];
                
                if(sum == -num[i]){
                    
                    ArrayList<Integer> trip = new ArrayList<Integer>();
                    trip.add(num[i]);
                    trip.add(num[start]);
                    trip.add(num[end]);
                    result.add(trip);
                    start++;
                    end--;
                    while(start < end && num[start] == num[start - 1]) start++;
                    while(end > start && num[end] == num[end + 1]) end--;
                }
                else if(sum > -num[i]) end--;
                else start++;
            }
        }
        
        return result;
    }
}
