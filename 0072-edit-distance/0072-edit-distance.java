class Solution {
    int dp[][];
    public int minDistance(String s, String t) {
        dp= new int[s.length()+1][t.length()+1];
        for(int[]arr: dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,s,t);
    }
    int solve(int i, int j, String s, String t){
        if(i==s.length()&&j==t.length()){
            return 0;
        }
        if(i==s.length()||j==t.length()){
            return s.length()-i + t.length()-j;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=solve(i+1,j+1,s,t);
        }
        int ins=1+solve(i,j+1,s,t);
        int del=1+solve(i+1,j,s,t);
        int rep=1+solve(i+1,j+1,s,t);

        return dp[i][j]=Math.min(ins,Math.min(del,rep));
    }
}