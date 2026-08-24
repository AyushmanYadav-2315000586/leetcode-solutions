class Solution {
    int[]parent;
    int[]rank;

    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y){
        int rX=find(x);
        int rY=find(y);

        if(rX==rY)return;

        if(rank[rX]<rank[rY]){
            int temp=rX;
            rX=rY;
            rY=temp;
        }

        parent[rY]=rX;

        if(rank[rX]==rank[rY]){
            rank[rX]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n=source.length;

        rank= new int[n];
        parent= new int [n];


        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(int[] edg: allowedSwaps){
            union(edg[0],edg[1]);
        }

        Map<Integer,Map<Integer,Integer>> grpFreq= new HashMap<>();

        for(int i=0; i<n; i++){
            int root=find(i);

            grpFreq.putIfAbsent(root, new HashMap<>());

            Map<Integer,Integer> freq= grpFreq.get(root);

            freq.put(source[i],freq.getOrDefault(source[i],0)+1);
        }

        int hd=0;

        for(int i=0; i<n; i++){
            int root=find(i);
            Map<Integer,Integer> freq=grpFreq.get(root);

            if(freq.getOrDefault(target[i],0)>0){
                freq.put(target[i],freq.get(target[i])-1);
            }else{
                hd++;
            }
        }
        return hd;
    }
}