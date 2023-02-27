/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return constructRecursive(grid, 0, 0, grid.length);
    }
    
    Node constructRecursive(int[][] grid, int x, int y, int length) {
        
        if (areGridValuesSame(grid, x, y, length)) {
            
            return new Node(grid[x][y] == 1, true);
            
        } else {
            
            Node root = new Node(false, false);

            root.topLeft = constructRecursive(grid, x, y, length / 2);
            root.topRight = constructRecursive(grid, x, y + length / 2, length / 2);
            root.bottomLeft = constructRecursive(grid, x + length / 2, y, length / 2);
            root.bottomRight = constructRecursive(grid, x + length / 2, y + length / 2, length / 2);

            return root;
        }
    }
    
    boolean areGridValuesSame(int[][] grid, int x, int y, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++)
                if (grid[i][j] != grid[x][y])
                    return false;
        }
        return true;
    }
    
}