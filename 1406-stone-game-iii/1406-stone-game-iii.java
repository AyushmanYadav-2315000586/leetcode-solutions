class Solution {
    int n;
    int []dp;
    public String stoneGameIII(int[] nums) {
        n=nums.length;
        dp= new int[n];
        Arrays.fill(dp,-1);
        int res=solve(0,nums);

        if(res>0) return "Alice";
        else if(res<0) return "Bob";
        else return "Tie";        

    }

    int solve(int i, int nums[]){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int res=Integer.MIN_VALUE;
        res=Math.max(res,nums[i]-solve(i+1,nums));
        if(i+1<n)res=Math.max(res,nums[i]+nums[i+1]-solve(i+2,nums));
        if(i+2<n)res=Math.max(res,nums[i]+nums[i+1]+nums[i+2]-solve(i+3,nums));
        return dp[i]=res;
    }
}