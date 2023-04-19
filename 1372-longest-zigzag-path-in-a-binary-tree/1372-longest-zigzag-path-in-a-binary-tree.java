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
    int maxLen = 0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return maxLen;
    }
    
    void dfs(TreeNode root, int leftCount, int rightCount) {
        
        if (root == null) {
            return;
        }
        
        maxLen = Math.max(maxLen, Math.max(leftCount, rightCount));
        if (root.left != null) {
            dfs(root.left, rightCount+1, 0);
        }
        if (root.right != null) {
           dfs(root.right, 0, leftCount+1); 
        }
        
    }
}