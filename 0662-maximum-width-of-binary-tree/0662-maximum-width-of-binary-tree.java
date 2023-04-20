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
    public int widthOfBinaryTree(TreeNode root) {
        
        int maxWidth = 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(root, 1));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int startIdx = 0, endIdx = 0;
            
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.remove();
                int index = pair.getValue();
                TreeNode node = pair.getKey();
                
                if(i == 0) {
                    startIdx = index;
                }
                if (i == size-1) {
                    endIdx = index;
                }
                
                if(node.left!=null) {
                    queue.add(new Pair<TreeNode, Integer>(node.left, 2*index));
                }
                if(node.right!=null) {
                    queue.add(new Pair<TreeNode, Integer>(node.right, 2*index+1));
                }
            }
            maxWidth = Math.max(maxWidth, endIdx - startIdx + 1);
        }
        
        return maxWidth;     
    }
}