class Solution {
    public boolean canFinish(int n, int[][] preq) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int []pre: preq){
            int u=pre[0];
            int v=pre[1];

            adj.get(v).add(u);
        }
        int []idg= new int[n];
        for(int i=0; i<n; i++){
            for(int nei: adj.get(i)){
                idg[nei]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<n; i++){
            if(idg[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node=q.remove();
            cnt++;
            for(int it: adj.get(node)){
                idg[it]--;
                if(idg[it]==0){
                    q.add(it);
                }
            }
        }
        return cnt==n;
    }
}