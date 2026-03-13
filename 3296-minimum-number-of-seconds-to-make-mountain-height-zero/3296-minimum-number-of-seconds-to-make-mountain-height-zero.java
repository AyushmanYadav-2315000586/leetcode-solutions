class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int max=Arrays.stream(workerTimes).max().getAsInt();
        long l=1;
        long r=(long) max * mountainHeight * (mountainHeight+1)/2;
        long res=0;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(check(mid,mountainHeight,workerTimes)){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    boolean check(long mid, int mountainHeight, int [] workerTimes){
        long h=0;
        for(int num: workerTimes){
            h+=(long)(Math.sqrt(2*(mid/num)+0.25)-0.5);
            if(h>=mountainHeight){
                return true;
            }
        }
        return h>=mountainHeight;
    }
}