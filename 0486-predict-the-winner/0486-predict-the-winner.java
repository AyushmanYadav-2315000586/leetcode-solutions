class Solution {
    int [][]dp;
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        dp= new int [n][n];
        for(int []arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,nums.length-1,nums)>=0;
    }
    int solve(int i, int j, int []nums){
        if(i==j){
            return nums[i];
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int left=nums[i]-solve(i+1,j,nums);
        int right=nums[j]-solve(i,j-1,nums);

        return dp[i][j]= Math.max(left,right);
    }
}