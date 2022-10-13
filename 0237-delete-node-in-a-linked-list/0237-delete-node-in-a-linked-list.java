/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
       
        ListNode currNode = node;
        
        currNode.val = currNode.next.val;
        currNode.next = currNode.next.next;
        
       
    }
}