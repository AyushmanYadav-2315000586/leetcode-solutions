class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points, Comparator.comparingInt(a->a[1]));

        int cnt=1;
        int lEP=points[0][1];
        for(int i=1; i<n; i++){
            int cSP=points[i][0];

            if(cSP>lEP){
                cnt++;
                lEP=points[i][1];
            }
        }
        return cnt;
    }
}