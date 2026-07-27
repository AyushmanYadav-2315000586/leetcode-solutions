class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        dp= new int [word1.length()+1][word2.length()+1];
        for(int []arr: dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,word1,word2);    
    }

    int solve(int i, int j, String s, String t){
        if(i==s.length() && j==t.length()) return 0;

        if(i==s.length() || j==t.length()) return s.length()-i + t.length()-j;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=solve(i+1,j+1,s,t);
        }

        return dp[i][j]=Math.min(1+solve(i+1,j,s,t),1+solve(i,j+1,s,t));
    }

}