class Solution {
    public int rotatedDigits(int n) {
        int cnt=0;
        for(int i=1; i<=n; i++){
            if(isGood(i)==1){
                cnt++;
            }
        }
        return cnt;    
    }
    int isGood(int num){
        if(num==0){
            return 0;
        }
        int r=isGood(num/10);
        int d=num%10;
        int d_c;
        if(d==0||d==1||d==8){
            d_c=0;
        }
        else if(d==2||d==5||d==6 ||d==9){
            d_c=1;
        }
        else{
            return 2;
        }
        if(r==2){
            return 2;
        }
        if(r==0 && d_c==0){
            return 0;
        }

        return 1;
    }

}




// class Solution {
//     public int rotatedDigits(int n) {
//         int cnt=0;
//         for(int i=1; i<=n; i++){
//             if(isGood(i)){
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
//     boolean isGood(int num){
//         boolean ch=false;
//         while(num>0){
//             int d=num%10;
//             if(d==3||d==4||d==7){
//                 return false;
//             }
//             if(d==2||d==5||d==6||d==9){
//                 ch=true;;
//             }
//             num/=10;
//         }
//         return ch;
//     }
// }