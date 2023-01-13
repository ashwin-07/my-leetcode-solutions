/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    boolean isPFound = false;
    boolean isQFound = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findLCA(root, p, q);
        return isPFound && isQFound? lca : null;
    }
    
    TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return null;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if (root == p) {
            isPFound = true;
            return root;
        }
        if (root == q) {
            isQFound = true;
            return root;
        }
        
        return left == null ? right : right == null?left:root;
    }
}