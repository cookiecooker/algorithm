public class Solution {
    public int largestRectangleArea(int[] height) {
        
        int[] len = Arrays.copyOf(height,height.length + 1);
        len[height.length] = 0;
        
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0;i < len.length;){
            
            if(stack.empty() || len[i] > len[stack.peek()]) stack.push(i++);
            else{
                
                int index = stack.pop();
                result = Math.max(result,len[index] * (stack.empty() ? i : i - stack.peek() - 1));
            }
            
        }
        
        return result;
    }
}
