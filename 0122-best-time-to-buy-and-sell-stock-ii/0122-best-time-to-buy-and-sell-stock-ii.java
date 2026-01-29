class Solution {
    public int maxProfit(int[] val) {
        int[][]dp= new int[val.length][2];
        for(int i=0; i<val.length; i++){
            for(int j=0; j<2; j++){
                dp[i][j]=-1;
            }
        }
        return fun(0,1,val,val.length,dp);
    }
    int fun(int idx, int buy, int[]val, int n, int[][]dp){
        if(idx==n) return 0;
        int profit=0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            profit=Math.max(-val[idx]+fun(idx+1,0,val,n,dp),0+fun(idx+1,1,val,n,dp));
        }
        else{
            profit=Math.max(val[idx]+fun(idx+1,1,val,n,dp),0+fun(idx+1,0,val,n,dp));
        }
        return dp[idx][buy]=profit;
    }
}