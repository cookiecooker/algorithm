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
    
    public void recoverTree(TreeNode root) {
        
       TreeNode cur = root,first = null,second = null,parent = null;
      
       while(cur != null){
           
           if(cur.left == null){
               
               if(parent != null){
                    if(first == null && cur.val < parent.val) first = parent;
                    else if(first != null && second == null && cur.val > first.val) second = parent;
               }
               parent = cur;
               cur = cur.right;
           }else{
               
               TreeNode pre = cur.left;
               
               while(pre.right != null && pre.right != cur) pre = pre.right;
               
               if(pre.right == null){
                   
                   pre.right = cur;
                   cur = cur.left;
               }else{
                   
                   if(first == null && cur.val < parent.val) first = parent;
                   else if(first != null && second == null && cur.val > first.val) second = parent;
                   
                   pre.right = null;
                   parent = cur;
                   cur = cur.right;
               }
           }
       }
       
       if(first != null){
           
           if(second == null) second = parent;
           int tmp = first.val;
           first.val = second.val;
           second.val = tmp;
       }
        
    }
}
