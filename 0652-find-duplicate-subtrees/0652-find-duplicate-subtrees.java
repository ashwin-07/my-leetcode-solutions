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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        postOrder(root, new HashMap<>(), result);
        return result;
    }

    public StringBuilder postOrder(TreeNode node, Map<String, Integer> strCount, List<TreeNode> result) {
        
        StringBuilder formedStr = new StringBuilder("");
        
        if (node == null) {
            return formedStr;
        }
        
        formedStr.append("(");
        formedStr.append(postOrder(node.left, strCount, result).toString()).append(")");
        formedStr.append(node.val);
        formedStr.append("(").append(postOrder(node.right, strCount, result).toString()).append(")");

        strCount.put(formedStr.toString(), strCount.getOrDefault(formedStr.toString(), 0) + 1);
        if (strCount.get(formedStr.toString()) == 2) {
            result.add(node);
        }
        
        return formedStr;
    }
}