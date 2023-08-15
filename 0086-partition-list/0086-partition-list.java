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
    public ListNode partition(ListNode head, int x) {
        
        ListNode lHead = new ListNode(0);
        ListNode gHead = new ListNode(0);
        
        ListNode lesser = lHead;
        ListNode greater = gHead;
        
        while (head != null) {
            
            if (head.val < x) {
                lesser.next = head;
                lesser = lesser.next;
            }
            else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
            
        }
        
        lesser.next = gHead.next;
        greater.next = null;
        
        return lHead.next;
        
    }
}