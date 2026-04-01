class Solution {
    public int[] shuffle(int[] nums, int n) {
        int size=2*n;

        int []res= new int[size];

        for(int i=0; i<n; i++){
            res[2*i]=nums[i];
            res[2*i+1]=nums[i+n];
        }
        return res;
    }
}