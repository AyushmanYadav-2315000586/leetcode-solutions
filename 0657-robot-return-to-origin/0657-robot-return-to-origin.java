class Solution {
    public boolean judgeCircle(String moves) {
        int n=moves.length();
        int x=0;
        int y=0;

        for(int i=0; i<n; i++){
            if(moves.charAt(i)=='U'){
                y++;
            }
            else if(moves.charAt(i)=='D'){
                y--;
            }
            else if(moves.charAt(i)=='R'){
                x++;
            }
            else{
                x--;
            }
        }

        return x==0&&y==0;
    }
}