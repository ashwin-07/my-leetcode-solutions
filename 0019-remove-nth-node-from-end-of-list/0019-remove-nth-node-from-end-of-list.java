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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int i = 0;
        
        ListNode leadPtr = head, trailPtr = head;
        while (i < n) {
            leadPtr = leadPtr.next;
            i++;
        }
        
        if (leadPtr == null) {
            return trailPtr.next;
        }
        
        while (leadPtr.next != null) {
            trailPtr = trailPtr.next;
            leadPtr = leadPtr.next;
        }
        
        trailPtr.next = trailPtr.next.next;
        
        return head;
        
        
        
    }
}