class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]= new int [n+1][amount+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= solve(0,coins,amount,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int solve(int i, int[] coins, int amount, int[][]dp){
        if(amount==0){
            return 0;
        }
        if(i==coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int skip=solve(i+1,coins,amount,dp);
        int take=Integer.MAX_VALUE;
        if(coins[i]<=amount){
            int sub=solve(i,coins,amount-coins[i],dp);
            if (sub != Integer.MAX_VALUE) {
                take=1+sub;
            }
        }
        return dp[i][amount]=Math.min(take,skip);
    }
}