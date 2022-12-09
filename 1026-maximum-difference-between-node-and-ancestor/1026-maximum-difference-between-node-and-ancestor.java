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
    public int maxAncestorDiff(TreeNode root) {
        
        return findMaxDiff(root, root.val, root.val);
        
    }
    
    public int findMaxDiff(TreeNode node, int minSoFar, int maxSoFar) {
        
        if (node == null) {
            return maxSoFar - minSoFar;
        }
        
        int min = Math.min(node.val, minSoFar);
        int max = Math.max(node.val, maxSoFar);
        
        int maxDiffInLeft = findMaxDiff(node.left, min, max);
        int maxDiffInRight = findMaxDiff(node.right, min, max);
        
        return Math.max(maxDiffInLeft, maxDiffInRight);
        
        
    }
}