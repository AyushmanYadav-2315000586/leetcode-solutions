class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int lf=landStartTime[i]+landDuration[i];
                int ws=Math.max(lf,waterStartTime[j]);
                int t1=ws+waterDuration[j];

                int wf=waterStartTime[j]+waterDuration[j];
                int ls=Math.max(wf,landStartTime[i]);
                int t2=ls+landDuration[i];

                ans=Math.min(ans,Math.min(t1,t2));
            }
        }
        return ans;

    }
}