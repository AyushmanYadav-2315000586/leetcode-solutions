class Solution {
    int m,n;
    int dp[][][];
    public int maxPathScore(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m][n][k+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int res=solve(grid,k,0,0,0);

        return res==Integer.MIN_VALUE?-1:res;
    }
    int solve(int [][]grid, int k, int i, int j, int cost){
        if(i>=m || j>=n){
            return Integer.MIN_VALUE;
        }
        int newCost=cost+(grid[i][j]>0?1:0);
        if(newCost>k){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][newCost]!=-1){
            return dp[i][j][newCost];
        }
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        int down=solve(grid,k,i+1,j,newCost);
        int right=solve(grid,k,i,j+1,newCost);

        return (Math.max(down,right)==Integer.MIN_VALUE?(dp[i][j][newCost]=Integer.MIN_VALUE):(dp[i][j][newCost]=Math.max(down,right)+grid[i][j]));
    }
}