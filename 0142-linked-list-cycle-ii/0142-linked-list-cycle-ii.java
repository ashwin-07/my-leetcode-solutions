/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode fptr = head;
        ListNode sptr = head;
        
        boolean hasCycle = false;
        
        while (fptr != null && fptr.next != null) {     
            fptr = fptr.next.next;
            sptr = sptr.next;
            if (fptr == sptr) {
                hasCycle = true;
                break;
            }  
        }
        
        if (!hasCycle) {
            return null;
        }
        
        fptr = head;
        while (fptr != sptr) {
            fptr = fptr.next;
            sptr = sptr.next;
        }
        
        return fptr;
    }
}