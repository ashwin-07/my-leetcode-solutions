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
    public int pairSum(ListNode head) {
        
        ListNode sptr = head, fptr = head;
        
        while (fptr != null && fptr.next != null) {
            fptr = fptr.next.next;
            sptr = sptr.next;
        }
        
        ListNode next, prev = null;
        while (sptr != null) {
            next = sptr.next;
            sptr.next = prev;
            prev = sptr;
            sptr = next;
        }
        
        sptr = head;
        int maxTwinSum = 0;
        
        while (prev != null) {
            maxTwinSum = Math.max(maxTwinSum, sptr.val + prev.val);
            prev = prev.next;
            sptr = sptr.next;
        }
        
        return maxTwinSum;
        
    }
}