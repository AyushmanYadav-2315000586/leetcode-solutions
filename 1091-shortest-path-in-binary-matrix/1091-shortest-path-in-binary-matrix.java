class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        if(grid[0][0] !=0 || grid[m-1][n-1]!=0) return -1;

        int[][]dirs={
            {1,1},{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,-1},{-1,1}
        };

        int [][]dist= new int[m][n];
        for(int []row:dist) Arrays.fill(row,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;

        while(!pq.isEmpty()){
            int []curr=pq.poll();
            int d=curr[0];
            int x=curr[1];
            int y=curr[2];

            for(int []dir: dirs){
                int nx=x+dir[0];
                int ny=y+dir[1];

                if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==0 && d+1<dist[nx][ny]){
                    dist[nx][ny]=d+1;
                    pq.add(new int[]{d+1,nx,ny});
                    grid[nx][ny]=1;
                }
            }
        }

        return dist[m-1][n-1]==Integer.MAX_VALUE?-1:dist[m-1][n-1]+1;
    }
}