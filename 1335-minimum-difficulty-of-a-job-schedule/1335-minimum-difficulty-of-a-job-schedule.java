class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int[][]dp= new int[301][11];
        for(int i=0; i<301; i++){
            Arrays.fill(dp[i],-1);
        }
        if(jobDifficulty.length<d){
            return -1;
        }
        int n=jobDifficulty.length;
        return solve(0, n, jobDifficulty, d,dp);
    }
    public int solve(int idx, int n, int []jd, int d, int [][] dp){
        if(d==1){
            int maxD=jd[idx];
            for(int i=idx; i<n; i++){
                maxD=Math.max(maxD,jd[i]);
            }
            return maxD;
        }
        if(dp[idx][d]!=-1){
            return dp[idx][d];
        }
        int maxD=jd[idx];
        int finalRes=Integer.MAX_VALUE;

        for(int i=idx; i<=n-d; i++){
            maxD=Math.max(maxD,jd[i]);
            int res=maxD+solve(i+1, n, jd, d-1,dp);
            finalRes=Math.min(finalRes,res);
        }
        return dp[idx][d]=finalRes;
    }
}