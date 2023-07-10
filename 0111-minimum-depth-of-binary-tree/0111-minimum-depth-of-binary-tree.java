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
    public int minDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int lHeight = minDepth(root.left);
        int rHeight = minDepth(root.right);
        
        return (lHeight == 0 || rHeight == 0)? lHeight + rHeight + 1 : Math.min(lHeight, rHeight) + 1;
        
    }
}


        