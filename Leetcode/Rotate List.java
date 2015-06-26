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
    public ListNode rotateRight(ListNode head, int n) {
        
        if(n==0 || head==null) return head;
        
        ListNode start=head, target=head;
        
        for(int i=0;i<n;++i) 
        {
            if(target==null)
            {
                // k > list.length
                int len = length(head);
                n = n%len;
                
                if(n==0) return head;  // multiple of list.length
                
                target=head;
                i=0;
            }
            
            target=target.next;
        }
        
        if(target==null) return head;  // k=list.length
        
        while(target!=null && target.next!=null)
        {
            target=target.next;
            start=start.next;
        }
        
        ListNode newHead = start.next;
        start.next=null;
        target.next=head;
        
        return newHead;
    }
    
    int length(ListNode head)
    {
        int len=0;
        while(head!=null)
        {
            len++;
            head=head.next;
        }
        
        return len;
    }
    
}
