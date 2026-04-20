class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int res=0;

        for(int i=0; i<n; i++){
            if(colors[i]!=colors[0]){
                res=Math.max(res,i);
            }
            if(colors[i]!=colors[n-1]){
                res=Math.max(res,Math.abs(i-(n-1)));
            }
        }

        return res;
    }
}