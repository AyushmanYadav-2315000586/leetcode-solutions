class Solution {
    int n;
    int []dp;
    public int maximumJumps(int[] nums, int target) {
        n=nums.length;
        dp= new int[n];
        Arrays.fill(dp,-2);
        int res=Integer.MIN_VALUE;

        res=Math.max(res,solve(nums,target,0));
        return res;
    }

    int solve(int []nums, int target, int i){
        if(i==n-1){
            return 0;
        }
        if(dp[i]!=-2){
            return dp[i];
        }
        int ans=-1;
        for(int j=i+1; j<n; j++){
            int diff=nums[j]-nums[i];
            
            if(diff>=-target && diff<=target){
                int next=solve(nums, target, j);

                if(next!=-1){
                    ans=Math.max(ans,1+next);
                }
            }
        }
        return dp[i]=ans;
    }
}