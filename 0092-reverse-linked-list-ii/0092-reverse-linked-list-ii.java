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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode nodeAfterEnd = head; //the node after the right node
        int i = 1;
        while (i <= n) {
            nodeAfterEnd = nodeAfterEnd.next;
            i++;
        }
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode nodeBeforeStart = temp;
        
        i = 1;
        while (i < m) {
            nodeBeforeStart = nodeBeforeStart.next;
            i++;
        }
        
        nodeBeforeStart.next = reverseList(nodeBeforeStart.next, m, n, nodeAfterEnd);
        
        return temp.next;
    }
    
    public ListNode reverseList(ListNode head, int m, int n, ListNode afterEnd) {
        ListNode prev = afterEnd;
        ListNode next = head;
        ListNode cur = head;
        
        while (m <= n && next != null) {
            next = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = next;
            m++;
        }
        head = prev;
        return head;
        
    }
    
    
    
}