class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0; i<m; i++){
            if(grid[0][i]==1){
                dfs(grid,0,i);
            }
            if(grid[n-1][i]==1){
                dfs(grid,n-1,i);
            }
        }
        for(int i=0; i<n; i++){
            if(grid[i][0]==1){
                dfs(grid,i,0);
            }
            if(grid[i][m-1]==1){
                dfs(grid,i,m-1);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    void dfs(int [][]grid, int i, int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]!=1){
            return;
        }

        grid[i][j]=2;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}