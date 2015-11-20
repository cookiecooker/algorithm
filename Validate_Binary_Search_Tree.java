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
    public boolean isValidBST(TreeNode root) {
        
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public boolean check(TreeNode root,int min,int max){
        
        if(root == null) return true;
        
        return (root.val > min) && (root.val < max) && check(root.left,min,root.val) && check(root.right,root.val,max);
    }
}
