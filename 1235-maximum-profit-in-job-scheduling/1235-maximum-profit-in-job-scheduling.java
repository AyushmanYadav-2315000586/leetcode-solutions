class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int arr[][]= new int [n][3];
        for(int i=0; i<n; i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        return solve(arr,0,n,dp);
    }
    int solve(int[][]arr, int i, int n, int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int next=getNextIdx(arr, i+1, arr[i][1],n);
        int taken = arr[i][2]+solve(arr,next,n,dp);

        int notTaken=solve(arr,i+1,n,dp);
        return dp[i]=Math.max(taken,notTaken);
    }
    int getNextIdx(int[][]arr, int l, int target, int n){
        int r=n-1;
        int result=n+1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid][0]>=target){
                result = mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return result;
    }
}