class Solution {
    int ans=0;
    public int integerReplacement(int n) {
        return solve((long)n);
    }

    int solve(long n){
        if(n==1){
            return 0;
        }

        if(n%2==0){
            ans=1+solve(n/2);
        }
        else{
            int minus=solve(n-1);
            int plus=solve(n+1);
            ans=1+Math.min(minus,plus);
        }

        return ans;
    }
}


// class Solution {
//     public int integerReplacement(int nu) {
//         int cnt=0;
//         long n=nu;
//         while(n>1){
//             if(n%2==0){
//                 n/=2;
//             }
//             else{
//                 if((n==3)||(n&2)==0){
//                     n--;
//                 }
//                 else{
//                     n++;
//                 }
//             }
//             cnt++;
//         }
//         return cnt;
//     }
// }