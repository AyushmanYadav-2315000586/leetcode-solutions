class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add( new ArrayList<>());
        }

        int []idg= new int[n];
        for(int []edg: invocations){
            int u=edg[0];
            int v=edg[1];
            adj.get(u).add(v);
            idg[v]++;
        }

        boolean[]sus= new boolean[n];

        Queue<Integer> q= new LinkedList<>();
        q.offer(k);
        sus[k]=true;

        while(!q.isEmpty()){
            int curr=q.poll();
            for(int nei: adj.get(curr)){
                idg[nei]--;
                if(!sus[nei]){
                    q.offer(nei);
                    sus[nei]=true;
                }
            }
        }

        List<Integer> ans= new ArrayList<>();
        boolean reWhole= false;

        for(int i=0; i<n;i++){
            if(sus[i] && idg[i]>0){
                reWhole=true;
                break;
            }
            if(!sus[i]){
                ans.add(i);
            }
        }
        if(reWhole){
            List<Integer> comp= new ArrayList<>();
            for(int i=0; i<n;i++){
                comp.add(i);
            }
            return comp;
        }
        return ans;

    }
}