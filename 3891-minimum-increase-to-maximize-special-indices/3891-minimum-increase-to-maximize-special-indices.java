class Solution {
    public long minIncrease(int[] nums) {
        int n=nums.length;

        if(n<=2){
            return 0;
            
        }

        int []cost= new int[n];

        for(int i=1; i<n-1; i++){
            cost[i]=Math.max(0,Math.max(nums[i-1],nums[i+1])-nums[i]+1);
        }

        if(n%2==1){
            long ans=0;
            for(int i=1; i<n-1; i+=2){
                ans+=cost[i];
            }
            return ans;
        }

        long[]pre=new long[n];
        long[]suf=new long[n];

        for(int i=1; i<n-1; i++){
            pre[i]=cost[i];
            if(i-2>=1) pre[i]+=pre[i-2];
        }
        for(int i=n-2; i>=1; i--){
            suf[i]=cost[i];
            if(i+2<n) suf[i]+=suf[i+2];
        }
        long ans=Long.MAX_VALUE;
        for(int i=1; i<n; i+=2){
            long left=(i-2>=1)?pre[i-2]:0;
            long right=(i+1<n-1)?suf[i+1]:0;
            ans=Math.min(ans,left+right);
        }
        return ans;
    }
}