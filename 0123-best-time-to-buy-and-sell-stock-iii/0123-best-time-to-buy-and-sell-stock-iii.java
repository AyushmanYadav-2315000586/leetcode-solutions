class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][]dp= new int[n][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return fun(0,1,prices, n,dp,2);
    }
    int fun(int idx, int buy, int[]prices, int n, int [][][]dp, int cap){
        if(idx==n) return 0;
        if(cap==0)  return 0;
        int profit=0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==1){
            profit=Math.max(-prices[idx]+ fun(idx+1,0,prices,n,dp,cap),0+fun(idx+1, 1,prices, n, dp,cap));
        }
        else{
            profit=Math.max(prices[idx]+fun(idx+1,1,prices,n,dp,cap-1),0+fun(idx+1,0,prices,n,dp,cap));
        }
        return dp[idx][buy][cap]=profit;
    }
}