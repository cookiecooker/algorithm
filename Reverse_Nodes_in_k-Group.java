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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(k == 1 || head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        
        dummy.next = head;
        
        for(ListNode prev = dummy, cur = dummy;;){
          
            int i = 1;
            for(;(i <= k) && (cur != null);i++) cur = cur.next;
                
            if(cur == null) break;    
            prev = cur = reverse(prev,prev.next,cur.next);
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode pre,ListNode start,ListNode end){
    
        ListNode cur = start;
        while(cur.next != end){
            
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = tmp;
        }
        
        return cur;
    }
}
