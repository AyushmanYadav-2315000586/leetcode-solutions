class Solution {
    int [][][][][] dp= new int[301][7][7][7][7];
    public int minimumDistance(String word) {
        for(int i=0; i<301; i++){
            for(int a=0; a<7; a++){
                for(int b=0; b<7; b++){
                    for(int c=0; c<7; c++){
                        Arrays.fill(dp[i][a][b][c],-1);
                    }
                }
            }
        }
        return solve(word,0,-1,-1,-1,-1);
    }
    int [] getCord(char ch){
        int pos=ch-'A';
        return new int[]{pos/6, pos%6};
    }
    int getDist(int x1,int y1, int x2, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    int solve(String word, int i, int x1, int y1, int x2, int y2){
        if(i>=word.length()){
            return 0;
        }
        if(dp[i][x1+1][y1+1][x2+1][y2+1]!=-1){
            return dp[i][x1+1][y1+1][x2+1][y2+1];
        }
        int []cord=getCord(word.charAt(i));
        int x=cord[0], y=cord[1];
        if(x1==-1&& y1==-1 && x2==-1 &&y2==-1){
            return dp[i][x1+1][y1+1][x2+1][y2+1]=solve(word, i+1, x, y, x2, y2);
        }

        if(x2==-1 && y2==-1){
            int moveF2=solve(word,i+1,x1,y1,x,y);
            int moveF1=getDist(x1,y1,x,y)+solve(word,i+1,x,y,x2,y2);

            return dp[i][x1+1][y1+1][x2+1][y2+1]=Math.min(moveF2,moveF1);
        }

        int mF1=getDist(x1,y1,x,y)+solve(word,i+1,x,y,x2,y2);
        int mF2=getDist(x2,y2,x,y)+solve(word,i+1,x1,y1,x,y);

        return dp[i][x1+1][y1+1][x2+1][y2+1]= Math.min(mF1,mF2);
    }
}