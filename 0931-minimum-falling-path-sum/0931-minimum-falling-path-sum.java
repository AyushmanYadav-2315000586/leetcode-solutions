class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int min=Integer.MAX_VALUE;
        if(m==1){
            for(int i=0; i<n; i++){
                min=Math.min(min,matrix[0][i]);
            }
            return min;
        };
        int[][]dp= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int col=0; col<n; col++){
            ans=Math.min(ans,fun(m-1,col,matrix,dp));
        }
        return ans;
    }

    int fun(int i, int j,  int[][]mat, int [][]dp){
        if(i<0 || j<0 || j>=mat[0].length) return Integer.MAX_VALUE;
        if(i==0) return dp[i][j]=mat[0][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int up=fun(i-1,j,mat,dp);
        int dL=fun(i-1,j-1,mat,dp);
        int dR=fun(i-1,j+1,mat,dp);
        return dp[i][j]=mat[i][j]+Math.min(up,Math.min(dL,dR));
     }
}