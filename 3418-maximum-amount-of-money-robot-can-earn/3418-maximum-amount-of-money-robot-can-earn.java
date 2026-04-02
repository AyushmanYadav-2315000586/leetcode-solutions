class Solution {
    int m,n;
    public int maximumAmount(int[][] coins) {
        m=coins.length;
        n=coins[0].length;
        int [][][]dp= new int [m+1][n+1][3];

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        return solve(coins,0,0,2,dp);
    }

    int solve(int [][] coins, int i, int j, int nu, int [][][]dp){
        if(i==m-1 && j==n-1){
            if(coins[i][j] <0 && nu >0){
                return 0;
            }
            return coins[i][j];
        }

        if(i>=m || j>=n){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j][nu]!=Integer.MIN_VALUE){
            return dp[i][j][nu];
        }


        int take=coins[i][j]+Math.max(solve(coins, i+1, j, nu,dp),solve(coins, i, j+1, nu,dp));

        int skip=Integer.MIN_VALUE;

        if(coins[i][j]<0 && nu>0){
            int skD=solve(coins, i+1, j, nu-1, dp);
            int skR=solve(coins, i, j+1, nu-1, dp);
            skip=Math.max(skD,skR);
        }

        return dp[i][j][nu]=Math.max(take,skip);

    }
}