class Solution {
    public int findTheWinner(int n, int k) {
        int idx= win(n,k);
        return idx+1;
    }
    int win(int n, int k){
        if(n==1) return 0;

        int idx=win(n-1,k);
        idx=(idx+k)%n;
        return idx;
    }
}