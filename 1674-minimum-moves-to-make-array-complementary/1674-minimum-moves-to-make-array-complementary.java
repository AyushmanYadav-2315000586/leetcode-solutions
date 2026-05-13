class Solution {
    public int minMoves(int[] nums, int limit) {
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        int []diff= new int[2*limit+2];
        for(int i=0; i<n/2; i++){
            int a=nums[i];
            int b=nums[nums.length-1-i];
            int sum=a+b;
            int low=Math.min(a,b)+1;
            int high=Math.max(a,b)+limit;
            diff[low]-=1;
            diff[high+1]+=1;

            diff[sum]-=1;
            diff[sum+1]+=1;
        }
        int bt=2*(n/2);
        int curr=0;
        for(int i=2; i<=2*limit; i++){
            curr+=diff[i];
            int tm=curr+bt;
            ans=Math.min(ans,tm);
        }
        return ans;
    }
}


// class Solution {
//     public int minMoves(int[] nums, int limit) {
//         int ans=Integer.MAX_VALUE;
//         for(int j=2; j<=2*limit; j++){
//             int tm=0;
//             for(int i=0; i<nums.length/2; i++){
//                 int a=nums[i];
//                 int b=nums[nums.length-1-i];
//                 int cs=a+b;
//                 int min=Math.min(a,b)+1;
//                 int max=Math.max(a,b)+limit;

//                 if(cs==j){
//                     tm+=0;
//                 }
//                 else if(min<=j&&j<=max){
//                     tm+=1;
//                 }
//                 else{
//                     tm+=2;
//                 }
//             }
//             ans=Math.min(ans,tm);
//         }
//         return ans;
//     }
// }