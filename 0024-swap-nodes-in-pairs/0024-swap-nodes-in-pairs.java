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
    
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        head = recurseSwap(head, true);
        return head;
    }
    
    public ListNode recurseSwap(ListNode node, boolean end) {
        
        if (node.next == null) {
            return node;
        }
        
        ListNode nextNode = recurseSwap(node.next, !end);
        if (end){
            node.next = nextNode.next;
            nextNode.next = node;
            return nextNode;
        }
        else {
            node.next = nextNode;
            return node;
        }
        
        
    }
    
    
//     public ListNode swapPairs(ListNode head) {
        
//         if (head == null || head.next == null) { 
//             return head;
//         }
        
//         ListNode fptr = head.next;
//         ListNode sptr = head;
//         head = fptr;
        
//         while (fptr != null) {
//             ListNode temp = fptr;
//             fptr.next = sptr;
//             fptr = temp.next;
//             if (fptr != null && fptr.next != null)
                
//             }   
        
        
//     }
}