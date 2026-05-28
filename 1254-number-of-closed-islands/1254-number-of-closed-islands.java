class Solution {
    int n;
    int m;
    public int closedIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0 && dfs(grid,i,j)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    boolean dfs(int [][]grid, int r, int c){
        if(r<0 || r>=n || c<0 || c>=m) return false;

        if(grid[r][c]==1){
            return true;
        }

        grid[r][c]=1;

        boolean left=dfs(grid,r,c-1);
        boolean right=dfs(grid,r,c+1);
        boolean up=dfs(grid,r-1,c);
        boolean down=dfs(grid,r+1,c);

        return left&&right&&up&&down;
    }
}