class Solution {
    public int findKthNumber(int n, int k) {
        int curr=1;
        k-=1;
        while(k>0){
            int cnt=cnt(curr,curr+1, n);
            if(cnt<=k){
                curr++;
                k-=cnt;
            }
            else{
                curr*=10;
                k-=1;
            }
        }
        return curr;
    }
    int cnt(long curr, long next, int n){
        int cnt_num=0;
        while(curr<=n){
            cnt_num+=(next-curr);
            curr*=10;
            next*=10;
            next=Math.min(next,(long)n+1);
        }
        return cnt_num;
    }
}