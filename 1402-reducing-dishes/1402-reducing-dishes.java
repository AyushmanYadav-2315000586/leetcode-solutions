class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        Arrays.sort(satisfaction);
        int [][]dp= new int [n+1][n+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,1,n,satisfaction, dp);
    }
    public int solve(int idx, int time , int n,int[] satisfaction, int [][]dp){
        if(idx==n){
            return 0;
        }
        if(dp[idx][time]!=-1){
            return dp[idx][time];
        }
        int include= satisfaction[idx]*time+solve(idx+1,time+1,n,satisfaction, dp);
        int exclude= solve(idx+1, time, n, satisfaction,dp);

        return dp[idx][time]= Math.max(include, exclude);
    }
}