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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if (root == null) {
            return false;
        }
        
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
    
    public boolean isSame(TreeNode a, TreeNode b) {
        
        if (a == null || b == null) {
            return a == b;
        }
        
        if (a.val != b.val) {
            return false;
        }
        
        return isSame(a.left, b.left) && isSame(a.right, b.right);
        
        
    }
}