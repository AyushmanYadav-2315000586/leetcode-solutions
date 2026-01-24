class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[]= new int[n];
        for(int j=0; j<n; j++){
            dp[j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }    
}


/*
    int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int j=0; j<n; j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
*/




/*
        int n=triangle.size();
        int[][]dp= new int[n+1][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return solve(0,0,n,triangle,dp);
    public int solve(int i, int j, int n, List<List<Integer>> triangle, int[][]dp){
        if(i==n-1){
            return triangle.get(n-1).get(j);
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int down=triangle.get(i).get(j)+solve(i+1,j,n,triangle,dp);
        int diagonal=triangle.get(i).get(j)+solve(i+1,j+1,n,triangle,dp);

        return dp[i][j]= Math.min(down,diagonal);
    }
    */