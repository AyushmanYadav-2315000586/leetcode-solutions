class Solution {
    final int mod=1000000007;
    public int numOfArrays(int n, int m, int k) {
        int[][][]dp= new int[n+1][k+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=k; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,0,n,m,k,dp);
    }
    public int solve(int idx, int searchCost, int maxSoFar, int n, int m, int k, int[][][]dp){
        if (searchCost > k) return 0;

        if(idx==n){
            if(searchCost==k){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[idx][searchCost][maxSoFar]!=-1){
            return dp[idx][searchCost][maxSoFar];
        }
        int result=0;
        for(int i=1; i<=m; i++){
            if(i>maxSoFar){
                result=(result+(solve(idx+1, searchCost+1, i, n,m,k,dp)))%mod;
            }
            else{
                result=(result+(solve(idx+1,searchCost,maxSoFar,n,m,k,dp)))%mod;
            }
        }
        return dp[idx][searchCost][maxSoFar]= result;
    }
}