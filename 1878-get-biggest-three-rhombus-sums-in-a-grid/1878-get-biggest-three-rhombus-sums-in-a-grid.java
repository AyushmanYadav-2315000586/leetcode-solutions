class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        TreeSet<Integer> pq= new TreeSet<>();

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                pq.add(grid[r][c]);

                for(int side=1; r-side>=0 && r+side<m && c-side>=0 && c+side<n; side++){
                    int sum=0;
                    for(int k=0; k<=side-1; k++){
                        sum+=grid[r-side+k][c+k];
                        sum+=grid[r+k][c+side-k];
                        sum+=grid[r+side-k][c-k];
                        sum+=grid[r-k][c-side+k];

                    }
                    pq.add(sum);
                }
            }
        }
        int size=Math.min(3,pq.size());
        int []ans= new int[size];

        for(int i=0; i<size; i++){
            ans[i]=pq.pollLast();
        }
        return ans;
    }
}