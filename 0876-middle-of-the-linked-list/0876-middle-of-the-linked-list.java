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
    public ListNode middleNode(ListNode head) {
        
        ListNode fptr = head.next, sptr = head;
        while (fptr!=null && fptr.next != null) {
            fptr = fptr.next.next;
            sptr = sptr.next;
        }
        
        return fptr != null ? sptr.next : sptr;
        
    }
}