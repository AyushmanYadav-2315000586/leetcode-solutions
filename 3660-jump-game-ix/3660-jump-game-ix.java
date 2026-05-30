class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        
        int []maxL=new int[n];
        int []minR=new int[n];

        maxL[0]=nums[0];
        minR[n-1]=nums[n-1];

        for(int i=1; i<n; i++){
            maxL[i]=Math.max(nums[i],maxL[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            minR[i]=Math.min(nums[i],minR[i+1]);
        }

        int []ans= new int[n];

        ans[n-1]=maxL[n-1];

        for(int i=n-2; i>=0; i--){
            if(maxL[i]<=minR[i+1]){
                ans[i]=maxL[i];
            }
            else{
                ans[i]=ans[i+1];
            }
        }

        return ans;

    }
}