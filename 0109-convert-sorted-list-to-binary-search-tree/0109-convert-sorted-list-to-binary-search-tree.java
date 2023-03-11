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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        if (head == null) {
            return null;
        }
        return convertToBST(head, null);
        
    }
    
    public TreeNode convertToBST(ListNode head, ListNode tail) {
        
        ListNode fptr = head;
        ListNode sptr = head;
        
        if (head == tail) {
            return null;
        }
        
        while (fptr != tail && fptr.next != tail) {
            fptr = fptr.next.next;
            sptr = sptr.next;
        }
        
        TreeNode tempNode = new TreeNode(sptr.val);
        tempNode.left = convertToBST(head, sptr);
        tempNode.right = convertToBST(sptr.next, tail);
        
        return tempNode;
        
    }
}