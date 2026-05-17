class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max=Math.max(max,nums[i]);
        }
        if(n!=max+1){
            return false;
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            if(nums[i]==max){
                cnt++;
            }
        }
        int []f= new int[max+1];
        for(int x: nums){
            f[x]++;
        }
        for(int i=1; i<max; i++){
            if(f[i]!=1){
                return false;
            }
        }
        return cnt==2;
    }
}