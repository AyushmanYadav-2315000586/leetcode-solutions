class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean vis[]= new boolean[v+1];
        int cnt=0;
        for(int i=0; i<v; i++){
            if(vis[i]==false){
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;
    }
    void dfs(int node, ArrayList<ArrayList<Integer>>adj, boolean []vis){
        vis[node]=true;
        for(Integer it: adj.get(node)){
            if(vis[it]==false){
                dfs(it,adj,vis);
            }
        }
    }
}