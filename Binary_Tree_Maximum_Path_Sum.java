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
    
    int max = Integer.MIN_VALUE;
    private int dfs(TreeNode root){
        
        if(root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val;
        if(left > 0) sum += left;
        if(right > 0) sum += right;
        max = Math.max(sum,max);
        return Math.max(left,right) > 0 ? root.val + Math.max(left,right) : root.val;
    }
    
    
    public int maxPathSum(TreeNode root) {
        
       dfs(root);
       return max;
    }
}
