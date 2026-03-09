class Solution {
    public void moveZeroes(int[] nums) {
        int l=0;
        for(int r=0; r<nums.length; r++){
            if(nums[r]!=0){
                swap(l,r,nums);
                l++;
            }
        }
    }
    void swap(int l, int r, int[] nums){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}