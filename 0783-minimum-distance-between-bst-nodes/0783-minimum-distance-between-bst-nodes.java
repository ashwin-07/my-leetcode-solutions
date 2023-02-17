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
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    
    public int minDiffInBST(TreeNode root) {
        inorderAndFind(root);
        return min;
    }
    
    void inorderAndFind(TreeNode curr) {
        
        if (curr == null) {
            return;
        }
        
        inorderAndFind(curr.left);
        if (prev != null) { 
            min = Math.min(min, Math.abs(curr.val - prev.val));
        }
        prev = curr;
        inorderAndFind(curr.right);
        
    }
    
    
}