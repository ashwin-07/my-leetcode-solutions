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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode kthFromStart = head, kthFromEnd = head;
        ListNode fptr = head, sptr = head;
        
        int i = 0;
        while(i < k - 1) {
            fptr = fptr.next;
            i++;
        }
        
        kthFromStart = fptr;
        
        while(fptr.next != null) {
			sptr = sptr.next;
            fptr = fptr.next;
        }
        
        kthFromEnd = sptr;
        
        //swapping values for now, 
        //nodes can also be swapped by tracking previous of each for kthFrom start and end
        int temp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = temp;
        
        return head;    
    }
}