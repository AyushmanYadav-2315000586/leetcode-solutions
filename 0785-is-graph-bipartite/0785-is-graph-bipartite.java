class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[]= new int [graph.length];

        for(int i=0; i<graph.length; i++){
            color[i]=-1;
        }

        for(int i=0; i<graph.length; i++){
            if(color[i]==-1){
                if(!bfs(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean bfs(int start, int[][]graph, int []color){
        Queue<Integer> q= new LinkedList<>();
        color[start]=0;
        q.add(start);

        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();

            for(int it:graph[node]){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}