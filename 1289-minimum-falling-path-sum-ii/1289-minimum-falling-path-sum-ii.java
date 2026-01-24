class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid[0].length;
        int ans=Integer.MAX_VALUE;
        int[][]dp= new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int j=0; j<n; j++){
            ans=Math.min(ans,solve(0,j,n,grid,dp));
        }
        return ans;
    }
    public int solve(int i, int j, int n, int[][]grid, int[][]dp){
        if(i==n-1){
            return grid[n-1][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=0; k<n; k++){
            if(k!=j){
                min=Math.min(min,solve(i+1,k,n,grid,dp));
            }
        }
        return dp[i][j]=grid[i][j]+min;
    }
}