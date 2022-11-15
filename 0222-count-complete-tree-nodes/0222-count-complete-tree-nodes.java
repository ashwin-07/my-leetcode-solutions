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
    public int countNodes(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int lHeight = findDepth(root.left);
        int rHeight = findDepth(root.right);
        
        if (lHeight == rHeight) {
            return countNodes(root.right) + (1 << lHeight);
        }
        else {
            return countNodes(root.left) + (1 << rHeight);
        }
    }
    
    
    
    public int findDepth(TreeNode node) {
        
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }
    
}