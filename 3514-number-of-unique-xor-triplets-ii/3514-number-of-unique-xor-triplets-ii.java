class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        int max=max(nums);
        int t=1;
        while(t<=max){
            t*=2;
        }
        boolean []arr= new boolean[t];
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                arr[nums[i]^nums[j]]=true;
            }
        }
        boolean []ans= new boolean[t];
        for(int i=0; i<t; i++){
            if(arr[i]){
                for(int val: nums){
                    ans[i^val]=true;
                }
            }
        }
        int a=0;
        for(int i=0; i<t; i++){
            if(ans[i]){
                a++;
            }
        }
        return a;
    }
    int max(int nums[]){
        int val=Integer.MIN_VALUE;
        for(int num:nums){
            val=Math.max(num,val);
        }
        return val;
    }
}