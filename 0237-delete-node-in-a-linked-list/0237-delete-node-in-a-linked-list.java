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
       
        ListNode currNode = node, prevNode = null;
        while (currNode.next != null) {
            prevNode = currNode;
            currNode.val = currNode.next.val;
            currNode = currNode.next;
        }
        
        prevNode.next = null;
       
    }
}