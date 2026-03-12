class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu= new DSU(n);
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            int m=edge[3];
            if(m==1){
                if(dsu.find(u)==dsu.find(v)){
                    return -1;
                }
                dsu.union(u,v);
            }
        }
        int res=-1;
        int l=1;
        int r=(int)2e5;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(check(n,edges,k,mid)){
                res=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
    }
    boolean check(int n, int[][] edges, int k, int mid){
        DSU dsu= new DSU(n);
        List<int[]> upgradeCandidates= new ArrayList<>();
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            int s=edge[2];
            int m=edge[3];
            if(m==1){
                if(s<mid){
                    return false;
                }
                dsu.union(u,v);
            }
            else{
                if(s>=mid){
                    dsu.union(u,v);
                }
                else if(2*s>=mid){
                    upgradeCandidates.add(new int[]{u,v});
                }
            }
        }
        for(int[] edge: upgradeCandidates){
            int u=edge[0];
            int v=edge[1];
            if(dsu.find(u)!=dsu.find(v)){
                if(k<=0){
                    return false;
                }
                dsu.union(u,v);
                k--;
            }
        }

        int root=dsu.find(0);
        for(int node=1; node<=n-1; node++){
            if(dsu.find(node)!=root){
                return false;
            }
        }
        return true;
    }
}

class DSU{
    int[]parent;
    int[]rank;
    DSU(int n){
        parent= new int [n];
        rank=new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    void union(int x, int y){
        int x_parent=find(x);
        int y_parent=find(y);
        if(x_parent==y_parent){
            return;
        }
        if(rank[x_parent]>rank[y_parent]){
            parent[y_parent]=x_parent;
        }
        else if(rank[x_parent]<rank[y_parent]){
            parent[x_parent]=y_parent;
        }
        else{
            parent[x_parent]=y_parent;
            rank[y_parent]++;
        }
    }
}