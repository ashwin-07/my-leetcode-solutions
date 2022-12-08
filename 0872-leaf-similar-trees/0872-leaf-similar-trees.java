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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(root1);
        stack2.push(root2);
        
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (getLeaf(stack1).val != getLeaf(stack2).val) return false;   
        }
        
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    
    public TreeNode getLeaf(Stack<TreeNode> stack) {        
       while (true) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            if (node.left == null && node.right == null) return node;
        }
    }
    
}