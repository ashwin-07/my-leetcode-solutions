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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (a, b) -> Integer.compare(a.val, b.val));
        
        
        for (ListNode node:lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        
        
        ListNode temp = new ListNode();
        ListNode head = temp; 
        
        while (!heap.isEmpty()) {
            temp.next = heap.poll();
            temp = temp.next;
            if (temp.next != null) {
                heap.add(temp.next);
            }
        }
        
        return head.next;
        
        
    }
}