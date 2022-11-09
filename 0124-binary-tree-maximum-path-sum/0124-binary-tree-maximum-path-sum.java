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
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
         findMaxPathSum(root);
        return max;
        
    }
    
    
    
    public int findMaxPathSum(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(findMaxPathSum(root.left), 0);
        int right = Math.max(findMaxPathSum(root.right), 0);
        max = Math.max(max,left+right+root.val);
        return Math.max(root.val+left, root.val+right);
        
        
        
    }
    
}