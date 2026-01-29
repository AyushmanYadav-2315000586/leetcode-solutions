class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[]dp= new int [n+1];
        Arrays.fill(dp,-1);
        int ans1=solve(0,cost,n,dp);
        int ans2=solve(1,cost,n,dp);
        return Math.min(ans1,ans2);
    }
    int solve(int idx, int []cost, int n, int[]dp){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int s1=cost[idx]+solve(idx+1,cost,n,dp);
        int s2=cost[idx]+solve(idx+2,cost,n,dp);
        return dp[idx]=Math.min(s1,s2);
    }
}