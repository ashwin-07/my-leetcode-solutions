class Solution {
    
    public class NodeDetails {
        int index;
        int[] query;

        public NodeDetails(int idx, int[] query) {
            this.index = idx;
            this.query = query;
        }
    }

    public int find(int[] parent, int node) {
        while (parent[node] != node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<NodeDetails> list = new LinkedList<>();
        
        for (int i = 0; i < queries.length; i++) {
            list.add(new NodeDetails(i, queries[i]));
        }

        list.sort(Comparator.comparingInt(a -> a.query[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        boolean[] res = new boolean[queries.length];
        int j = 0;
        
        for (NodeDetails t : list) {
            while (j < edgeList.length && edgeList[j][2] < t.query[2]) {
                int parent1 = find(parent, edgeList[j][0]);
                int parent2 = find(parent, edgeList[j][1]);
                if (parent1 != parent2) {
                    parent[parent1] = parent2;
                }
                j++;
            }
            res[t.index] = find(parent, t.query[0]) == find(parent, t.query[1]);
        }
        
        return res;
    }
}