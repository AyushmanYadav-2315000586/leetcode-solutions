class Solution {
    public int[] sumZero(int n) {
        int i=0;
        int j=n-1;
        int[]arr= new int[n];
        int start=1;
        while(i<j){
            arr[i]=start;
            arr[j]=-start;
            i++;
            j--;
            start++;
        }
        return arr;

    }
}