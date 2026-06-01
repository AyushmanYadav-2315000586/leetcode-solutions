class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        Arrays.sort(cost);
        int c=0;
        int cnt=0;
        for(int i=n-1; i>=0; i--){
            if(cnt<2){
                c+=cost[i];
                cnt++;
            }
            else{
                cnt=0;
            }
        }
        return c;
    }
}