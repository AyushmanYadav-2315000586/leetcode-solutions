class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj= new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int []time: times){
            int u=time[0];
            int v=time[1];
            int w=time[2];

            adj.get(u).add(new int[]{v,w});
        }
        int []dist= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});
        dist[k]=0;

        while(!pq.isEmpty()){
            int []curr=pq.poll();

            int d=curr[0];
            int node=curr[1];

            if(d>dist[node]){
                continue;
            }

            for(int[] edg: adj.get(node)){
                int nxt=edg[0];
                int wei=edg[1];

                if(d+wei<dist[nxt]){
                    dist[nxt]=d+wei;
                    pq.offer(new int[]{dist[nxt],nxt});
                }
            }
        }

        int max=Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}