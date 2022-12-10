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
    
    long max = 0, totalSum;
    
    public int maxProduct(TreeNode root) {
        totalSum = postOrderAndSum(root);
        
        postOrderAndSum(root);
        
        return  (int)(max % 1000000007);
    }
    
    public int postOrderAndSum(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int leftSum = postOrderAndSum(root.left);
        int rightSum = postOrderAndSum(root.right);
        
        int currSum = leftSum + rightSum + root.val;
        
        max = Math.max(max, currSum * (totalSum - currSum));
        
        return currSum;
    }
    
    
}