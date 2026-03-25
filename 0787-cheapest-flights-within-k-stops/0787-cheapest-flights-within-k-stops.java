class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int []e: flights){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            adj.get(u).add(new int[]{v,w});
        }

        Queue<int[]>q= new LinkedList<>();

        q.add(new int[]{0,src,0});
        int []dist= new int[n];
        Arrays.fill(dist,(int)1e9);
        
        dist[src]=0;

        while(!q.isEmpty()){
            int[]curr= q.peek();
            q.remove();
            int stops=curr[0];
            int node=curr[1];
            int cost=curr[2];

            if(stops>k) continue;

            for(int [] nei: adj.get(node)){
                int adjNode=nei[0];
                int wt=nei[1];

                if(cost+wt<dist[adjNode] && stops<=k){
                    dist[adjNode]=cost+wt;
                    q.add(new int[]{stops+1, adjNode, cost+wt});
                }
            }
        }

        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
    }
}