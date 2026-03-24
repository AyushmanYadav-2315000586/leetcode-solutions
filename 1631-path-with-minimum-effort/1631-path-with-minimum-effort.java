class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int [][]dist= new int[n][m];
        for(int[] rows: dist){
            Arrays.fill(rows,(int)1e9);
        }

        dist[0][0]=0;

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};

        while(!pq.isEmpty()){
            int []curr= pq.poll();
            int d=curr[0];
            int x=curr[1];
            int y=curr[2];

            if(x==n-1 && y==m-1) return d;

            for(int i=0; i<4; i++){
                int nr=x+dr[i];
                int nc=y+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newEffort=Math.max(Math.abs(heights[x][y]-heights[nr][nc]),d);

                    if(newEffort<dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.add(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}