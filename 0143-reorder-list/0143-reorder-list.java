/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode midPrev = findPrevToMid(head);
        if (midPrev == null) {
            return;
        }
        
        ListNode node2 = midPrev.next;
        midPrev.next = null;
        ListNode node1 = head;
        
        node2 = reverse(node2);
       
        //join
        while (node1 != null) { 
            ListNode node1Next = node1.next;
            ListNode node2Next = node2.next;
            node1.next = node2;
            if (node1Next != null)
                node2.next = node1Next;
            node1 = node1Next;
            node2 = node2Next;  
        }
        
        
    }
    
    public ListNode findPrevToMid(ListNode head) {
        ListNode sptr = head, fptr = head, prev = null;
        while (fptr != null && fptr.next != null) {
            fptr = fptr.next.next;
            prev = sptr;
            sptr = sptr.next;
        }
        return prev;
    }
    
    public ListNode reverse(ListNode curr) {
     
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    
}

