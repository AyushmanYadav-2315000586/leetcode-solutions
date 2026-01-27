class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]arr=new int[n];
        int size=0;
        for(int i=0; i<n; i++){
            int left=0,right=size;
            while(left<right){
                int mid=(left+right)/2;
                if(arr[mid]<nums[i]){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }

            arr[left]=nums[i];
            if(left==size) size++;
        }
        return size;
    }
}



        // int[][]dp=new int[nums.length][nums.length+1];
        // for(int i=0; i<nums.length; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(0,-1,nums,dp);
    /*public int solve(int idx, int prev, int[]nums, int[][]dp){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int skip=solve(idx+1,prev,nums,dp);
        int pick=0;
        if(prev==-1|| nums[idx]>nums[prev]){
            pick=1+solve(idx+1,idx,nums,dp);
        }
        return dp[idx][prev+1]= Math.max(skip,pick);
    }*/