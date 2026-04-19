class Solution {
    public int maxDistance(int[] n1, int[] n2) {
        int i=0,j=0;
        int n=n1.length;
        int m=n2.length;
        int max=0;
        while(i<n && j<m){
            if(n1[i]>n2[j]){
                i++;
            }
            else{
                max=Math.max(max,j-i);
                j++;
            }
        }
        return max;
    }
}