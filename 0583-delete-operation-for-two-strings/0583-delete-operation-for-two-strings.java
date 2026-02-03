class Solution {
    public int minDistance(String word1, String word2) {

        int [][]dp= new int [word1.length()+1][word2.length()+1];
        for(int i=0; i<word1.length()+1; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(word1,word2,0,0,dp);
    }
    int solve(String s1, String s2, int i, int j, int[][]dp){
        if(i==s1.length() && j==s2.length()){
            return 0;
        }
        if(i==s1.length() || j==s2.length()){
            return Math.max(s1.length()-i , s2.length()-j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return solve(s1,s2,i+1,j+1,dp);
        }
        int sk1=1+solve(s1,s2,i+1,j,dp);
        int sk2=1+solve(s1,s2,i,j+1,dp);
        return dp[i][j]= Math.min(sk1,sk2);        
    }
}