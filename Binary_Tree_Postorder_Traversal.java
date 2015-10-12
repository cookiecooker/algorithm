/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        while(!stack.empty()){
            
            TreeNode node = stack.peek();
            
            if(node.left == null && node.right == null){
                
                result.add(node.val);
                stack.pop();
            }
            
            if(node.left != null){
                
                stack.push(node.left);
                node.left = null;
                continue;
            }
            
            if(node.right != null){
                
                stack.push(node.right);
                node.right = null;
                continue;
            }
        }
        
        return result;
    }
}
