class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n=piles.size();
        int dp[][]= new int[n+1][k+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0, piles, k, n, dp);
    }
    int solve(int i, List<List<Integer>> piles, int k, int n, int [][]dp){

        if(i>=n){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int not_taken=solve(i+1, piles, k, n,dp);
        int taken=0; int sum=0;
        for(int j=0; j<Math.min(piles.get(i).size() ,k ); j++){
            sum+=piles.get(i).get(j);
            taken=Math.max(taken, sum+solve(i+1, piles, k-(j+1),n,dp));
        }

        return dp[i][k]=Math.max(taken,not_taken);
    }
}