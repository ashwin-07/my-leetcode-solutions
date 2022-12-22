class Solution {
    int[] res, count;
    ArrayList<HashSet<Integer>> graph;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList<HashSet<Integer>>();
        res = new int[n];
        count = new int[n];
        for (int i = 0; i < n ; ++i)
            graph.add(new HashSet<Integer>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int root, int pre) {
        for (int i : graph.get(root)) {
            if (i == pre) continue;
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }


    public void dfs2(int root, int pre) {
        for (int i : graph.get(root)) {
            if (i == pre) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }
}