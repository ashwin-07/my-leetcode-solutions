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
    
    HashMap<Integer, Integer> nodeInorderIdx = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        IntStream.range(0, inorder.length).forEach(idx -> nodeInorderIdx.put(inorder[idx], idx));
                System.out.println(nodeInorderIdx);
        return constructTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode constructTree(int[] preorder, int[] inorder,
                                  int prestart, int preend, int instart, int inend) {
        
        if (prestart > preend || instart > inend) {
            return null;
        }
        
        int val = preorder[prestart];
        
        TreeNode node = new TreeNode(val);
        
        int inorderIdx = nodeInorderIdx.get(val);
        
        int leftNodesCount = inorderIdx - instart;

        node.left = constructTree(preorder, inorder, prestart+1, prestart+leftNodesCount, instart, inorderIdx - 1);
        node.right = constructTree(preorder, inorder, prestart+leftNodesCount+1, preend, inorderIdx+1, inend);
        return node;
            
    }
    

}