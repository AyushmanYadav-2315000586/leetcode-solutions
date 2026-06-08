class Solution {
    public int[] pivotArray(int[] nums, int p) {
        int n=nums.length;
        int[]arr=new int[n];
        int idx=0;
        for(int num: nums){
            if(num<p){
                arr[idx++]=num;
            }
        }
        for(int num: nums){
            if(num==p){
                arr[idx++]=num;
            }
        }
        for(int num: nums){
            if(num>p){
                arr[idx++]=num;
            }
        }
        return arr;
    }
}   