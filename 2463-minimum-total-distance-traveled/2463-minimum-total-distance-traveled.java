class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory, Comparator.comparingInt(a->a[0]));
        Collections.sort(robot);

        int m=robot.size();

        List<Integer> position= new ArrayList<>();

        for(int []f: factory){
            int pos=f[0];
            int limit=f[1];
            for(int i=0; i<limit; i++){
                position.add(pos);
            }
        }

        int n=position.size();
        long[][]dp= new long[m+1][n+1];
        for(long [] r: dp){
            Arrays.fill(r,-1);
        }
        return solve(0,0,robot,position,dp);
    }

    long solve(int ri, int fi, List<Integer> robot, List<Integer> pos, long[][]dp){
        if(ri>=robot.size()){
            return 0;
        }

        if(fi>=pos.size()){
            return (long)1e12;
        }

        if(dp[ri][fi]!=-1){
            return dp[ri][fi];
        }
        long tCF=Math.abs(robot.get(ri)-pos.get(fi))+solve(ri+1,fi+1,robot,pos,dp);
        long skip=solve(ri,fi+1,robot,pos,dp);
        return dp[ri][fi]=Math.min(tCF,skip);
    }
}