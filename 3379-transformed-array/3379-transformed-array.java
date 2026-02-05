class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int []res= new int [n];
        for(int i=0; i<n; i++){
            int find=i+nums[i];
            if(nums[i]==0){
                res[i]=nums[i];
            }
            else if(find<0){
                res[i]=nums[(find%n+n)%n];
            }
            else if(find>=n){
                res[i]=nums[(find%n)];
            }
            else{
                res[i]=nums[find];
            }
        }
        return res;
    }
}