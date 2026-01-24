class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        Boolean [][]dp= new Boolean[nums.length][sum+1];
        return solve(0, nums, sum,dp);
    }

    public boolean solve(int idx, int []nums, int sum,Boolean [][]dp){
        if(sum==0) return true;
        if(idx==nums.length || sum<0){
            return false;
        }
        if(dp[idx][sum]!=null){
            return dp[idx][sum];
        }
        boolean take= solve(idx+1, nums, sum-nums[idx], dp);
        boolean skip= solve(idx+1, nums, sum, dp);

        return dp[idx][sum]=take||skip;
    }
}