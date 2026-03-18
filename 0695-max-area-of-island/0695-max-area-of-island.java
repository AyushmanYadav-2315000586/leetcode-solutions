class Pair{
    int r;
    int c;
    Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int maxArea=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int area=bfs(grid,i,j);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    int bfs(int grid[][],int i, int j){
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j));
        grid[i][j]=0;
        int []delRow={1,-1,0,0};
        int []delCol={0,0,1,-1};
        int area=0;

        while(!q.isEmpty()){
            Pair curr=q.remove();
            int row=curr.r;
            int col=curr.c;
            area++;
            for(int t=0; t<4; t++){
                int nr=row+delRow[t];
                int nc=col+delCol[t];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    grid[nr][nc]=0;
                }
            }
        }
        return area;
    }
}