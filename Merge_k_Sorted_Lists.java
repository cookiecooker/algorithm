/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
   
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        
        if(lists.size() == 0) return null;
        
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
            new Comparator<ListNode>(){
                
            public int compare(ListNode a, ListNode b){
                if(a.val > b.val) return 1;
                else if(a.val == b.val) return 0;
                else return -1;
            }
            
        });
        
        for(ListNode i : lists) 
            if(i != null)   q.add(i);
            
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        
        while(q.size() != 0){
            
            ListNode temp = q.poll();
            pre.next = temp;
            
            if(temp.next != null) q.add(temp.next);
            
            pre = pre.next;
        }
        
        return head.next;
    }
}
