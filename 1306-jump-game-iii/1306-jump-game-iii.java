class Solution {
    public boolean canReach(int[] arr, int start) {
        return solve(arr,start);
    }
    boolean solve(int[]arr, int i){
        if(i<0||i>=arr.length||arr[i]<0){
            return false;
        }
        if(arr[i]==0){
            return true;
        }
        arr[i]*=-1;
        boolean a=solve(arr,i+arr[i]);
        boolean b=solve(arr,i-arr[i]);

        return a||b;
    }
}