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
    public boolean isCompleteTree(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        boolean haveSeenNullNode = false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode == null) {
                haveSeenNullNode = true;
                continue;
            }
            if (haveSeenNullNode) {
               return false; 
            }
            queue.add(currNode.left);
            queue.add(currNode.right);
        }
        
        return true;    
    }
}