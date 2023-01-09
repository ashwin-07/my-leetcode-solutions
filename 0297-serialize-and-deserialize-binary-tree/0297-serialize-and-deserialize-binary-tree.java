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

    private final String NULL_NODE = "#";
    private final String DELIMITER = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        buildSerializedValue(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public void buildSerializedValue(TreeNode root, StringBuilder sb) {
        
        if (root == null) {
            sb.append(NULL_NODE).append(DELIMITER);
            return;
        }
        
        sb.append(root.val).append(DELIMITER);
        buildSerializedValue(root.left, sb);
        buildSerializedValue(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue queue = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        TreeNode root = buildTree(queue);
        return root;  
    }
    
    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (!val.equals(NULL_NODE)) {
            TreeNode newNode = new TreeNode(Integer.parseInt(val));
            newNode.left = buildTree(queue);
            newNode.right = buildTree(queue);
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