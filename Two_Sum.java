public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        HashMap<Integer,Integer> record = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        
        for(int i = 0;i < numbers.length;i++) record.put(numbers[i],i);
        
        for(int i = 0;i < numbers.length;i++)
            if(record.containsKey(target - numbers[i]) &&  record.get(target - numbers[i]) != i){
                
                result[0] = i + 1;
                result[1] = record.get(target - numbers[i]) + 1;
                break;
            }
        
        return result;
    }
}
