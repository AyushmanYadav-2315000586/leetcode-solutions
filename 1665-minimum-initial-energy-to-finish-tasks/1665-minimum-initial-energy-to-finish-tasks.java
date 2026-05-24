class Solution {

    boolean isPossible(int [][]tasks, int mid){
        for(int [] task: tasks){
            int act=task[0];
            int min=task[1];

            if(min>mid){
                return false;
            }
            mid-=act;
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int l=0;
        int r=(int)1e9;

        Arrays.sort(tasks,(a,b)->{
            int d1=a[1]-a[0];
            int d2=b[1]-b[0];

            return d2-d1;
        });
        int res=Integer.MAX_VALUE;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(isPossible(tasks,mid)){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
}