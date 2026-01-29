class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0 ){
            return -1;
        }
        boolean flag=false;
        int n=1;
        int cnt=1;
        while(!flag){
            if(n%k==0){
                flag=true;
            }
            else{
                n=((n*10)+1)%k;
                cnt++;
            }
        }
        return cnt;
    }
}