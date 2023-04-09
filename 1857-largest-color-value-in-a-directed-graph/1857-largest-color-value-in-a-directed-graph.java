class Solution {
    
    public int largestPathValue(String colors, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        int n=colors.length();
        char[] colourCount = colors.toCharArray();

        for(int i=0; i<n; i++) {
            graph.add(i, new ArrayList<>());
        }
        
        int[] inDegree=new int[n];
        for(int[] edge:edges) {
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
            graph.get(from).add(to);
        }

        int[][] nodeColorCount=new int[n][26];
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                nodeColorCount[i][colourCount[i]-'a']=1;
            }
        }

        int maxColorCountInPath = 0, noOfVisitedNodes = 0;

        while(!queue.isEmpty()) { 
            int node = queue.poll();
            noOfVisitedNodes++;
            
            int maxColorCountInCurrPath = getMax(nodeColorCount[node]);
            maxColorCountInPath = Math.max(maxColorCountInPath, maxColorCountInCurrPath);

            for(int childNode:graph.get(node)) {
                for(int i=0; i<26; i++) {
                    int colorCountInPath = nodeColorCount[node][i] + (colourCount[childNode]-'a'== i ? 1 : 0);
                    nodeColorCount[childNode][i] = Math.max(nodeColorCount[childNode][i], colorCountInPath);
                }
                
                inDegree[childNode]--;

                if(inDegree[childNode]==0){
                    queue.add(childNode);
                }
            }
        }
        
        return noOfVisitedNodes == n? maxColorCountInPath:-1;
    }
    

    int getMax(int[] num){
        int max=num[0];
        for(int n:num){
            max=Math.max(n,max);
        }
        return max;
    }
}