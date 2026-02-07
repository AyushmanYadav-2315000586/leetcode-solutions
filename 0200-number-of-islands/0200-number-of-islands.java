class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int [][]vis= new int[n][m];
        int cnt=0;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return cnt;
    }

    void bfs(int r, int c, int[][]vis, char[][]grid){
        vis[r][c]=1;
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(r,c));
        int n=grid.length;
        int m=grid[0].length;

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();

            for(int dr=-1; dr<=1; dr++){
                for(int dc=-1; dc<=1; dc++){
                    if(Math.abs(dr) + Math.abs(dc)!=1){
                        continue;
                    }
                    int nr=row+dr;
                    int nc=col+dc;
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && vis[nr][nc]==0){
                        vis[nr][nc]=1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
    }
}