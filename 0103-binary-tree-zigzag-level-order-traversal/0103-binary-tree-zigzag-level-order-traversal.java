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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if (root == null) {
            return new LinkedList<>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        
        boolean isZig = false;
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            
            while (size > 0) {
                TreeNode node = queue.poll();
                if (isZig) {
                    level.add(0, node.val);
                }
                else {
                    level.add(node.val);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
                
            }
            
            isZig=!isZig;
            result.add(level);
  
        }
        
        return result;  
    }
}
