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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preStart]);
        
        int nodeInInorderIdx = 0;
        
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == node.val) {
                nodeInInorderIdx = i;
                break;
            }
        }
        
        int leftSideLen = nodeInInorderIdx - inStart;
        
        node.left = construct(preorder, preStart+1, leftSideLen + preStart, inorder, inStart, nodeInInorderIdx-1);
        
        node.right = construct(preorder, leftSideLen + preStart + 1, preEnd, inorder, nodeInInorderIdx + 1, inEnd);

        return node;
    }
}