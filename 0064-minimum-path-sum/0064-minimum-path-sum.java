class Solution {
    int m,n;
    int [][]dp;
    public int minPathSum(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(0,0,grid,dp);
        return ans;
    }
    int solve(int i, int j, int[][]grid, int [][]dp){
        if(i>m-1 || j>n-1){
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int d=solve(i+1,j,grid,dp);
        int r=solve(i,j+1,grid,dp);

        return dp[i][j]=grid[i][j]+Math.min(d,r);
    }
}