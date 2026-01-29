class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[]arr1= new int[n-1];
        for(int i=0; i<n-1; i++){
            arr1[i]=nums[i];
        }
        int []arr2= new int[n-1];
        for(int i=1; i<n; i++){
            arr2[i-1]=nums[i];
        }
        int []dp1= new int[n];
        int []dp2= new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int exclude=fn(arr1.length-1,arr1,dp1);
        int include=fn(arr2.length-1,arr2,dp2);
        return Math.max(exclude,include);
    }

    int fn(int idx, int nums[], int dp[]){
        if(idx==0) return nums[idx];
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int pick=nums[idx]+fn(idx-2,nums,dp);
        int notPick=fn(idx-1,nums,dp);
        return dp[idx]=Math.max(pick,notPick);
    }
}