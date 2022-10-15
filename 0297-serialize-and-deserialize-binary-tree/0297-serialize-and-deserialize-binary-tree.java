/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private static final String NULL_NODE = "X";
    private static final String NODE_DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serializedVal = new StringBuilder();
        preorderBuildString(root, serializedVal);
        return serializedVal.toString();
    }
    
    public void preorderBuildString(TreeNode root, StringBuilder serializedVal) {
        
        if (root == null) {
            serializedVal.append(NULL_NODE).append(NODE_DELIMITER);
        }
        else {
            serializedVal.append(root.val).append(NODE_DELIMITER);
            preorderBuildString(root.left, serializedVal);
            preorderBuildString(root.right, serializedVal);
        }
        
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = buildTreeFromString(new LinkedList<>(Arrays.asList(data.split(NODE_DELIMITER))));
        return root;
    }
    
    
    public TreeNode buildTreeFromString(Queue<String> queue) {
        
        String currElem = queue.poll();
        if (!NULL_NODE.equals(currElem)) {
            TreeNode newNode = new TreeNode(Integer.parseInt(currElem));
            newNode.left = buildTreeFromString(queue);
            newNode.right = buildTreeFromString(queue);
            return newNode;
        }
        else {
            return null;
        }
        
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));