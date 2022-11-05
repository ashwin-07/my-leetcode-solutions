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
    public ListNode rotateRight(ListNode head, int k) {
        
        ListNode fptr = head;
        ListNode lptr = head;
        
        ListNode temp = head;
        int length = 0;
        
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        if (k == 0 || length == 0){
            return head;
        }
        
        int rotations = k % length;
        
        if (rotations == 0) {
            return head;
        }
        
        int lead = 0;
        
        while (lead < rotations) {
            lptr = lptr.next;
            lead++;
        }
        
        while (lptr.next != null) {
            lptr = lptr.next;
            fptr = fptr.next;
        }
        
        temp = fptr;
        fptr = fptr.next;
        temp.next = null;
        lptr.next = head;
        head = fptr;
        
        return head;
        
    }
}