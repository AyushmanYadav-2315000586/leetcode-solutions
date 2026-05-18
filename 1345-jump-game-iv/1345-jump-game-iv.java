class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        HashMap<Integer,ArrayList<Integer>> map= new HashMap<>();
        boolean vis[]= new boolean[n];

        for(int i=0; i<n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q= new LinkedList<>();
        q.offer(0);
        vis[0]=true;
        int step=0;

        while(!q.isEmpty()){
            int size=q.size();

            while(size-->0){
                int curr=q.poll();
                if(curr==n-1){
                    return step;
                }
                int l=curr-1;
                int r=curr+1;

                if(l>=0 && !vis[l]){
                    q.offer(l);
                    vis[l]=true;
                }
                if(r<=n-1 && !vis[r]){
                    q.offer(r);
                    vis[r]=true;
                }
                if(map.containsKey(arr[curr])){
                    for(int idx: map.get(arr[curr])){
                        if(!vis[idx]){
                            q.offer(idx);
                            vis[idx]=true;
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            step++;
        }
        return step;
    }
}