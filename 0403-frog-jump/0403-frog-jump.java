class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if(stones[1]!=1){
            return false;
        }
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(stones[i],i);
        }
        int[][]dp= new int[2001][2001];
        for(int i=0; i<2000; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(stones,0,0,map,dp);
    }
    public boolean solve(int []stones, int idx, int prevJump, HashMap<Integer,Integer> map, int [][]dp){
        if(idx==stones.length-1){
            return true;
        }
        boolean result =false;
        if(dp[idx][prevJump]!=-1){
            return dp[idx][prevJump]==1;
        }
        for(int nextJump=prevJump-1; nextJump<=prevJump+1; nextJump++){
            if(nextJump>0){
                int nextStone=stones[idx]+nextJump;

                if(map.containsKey(nextStone)){
                    result=result||solve(stones, map.get(nextStone), nextJump, map, dp);
                }
            }
        }
        dp[idx][prevJump]=(result?1:0);
        return result;
    }
}