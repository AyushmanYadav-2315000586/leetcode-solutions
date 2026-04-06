class Solution {
    public int robotSim(int[] com, int[][] obstacles) {
        Set<String> set= new HashSet<>();
        for(int[]obs: obstacles){
            String key=obs[0]+"_"+obs[1];
            set.add(key);
        }
        int x=0;
        int y=0;
        int maxD=0;

        int []dir={0,1};
        int n=com.length;
        for(int i=0; i<n; i++){
            if(com[i]==-1){
                dir=new int[]{dir[1],-dir[0]};
            }
            else if(com[i]==-2){
                dir=new int[]{-dir[1],dir[0]};
            }
            else{
                for(int j=0; j<com[i]; j++){
                    int nx=x+dir[0];
                    int ny=y+dir[1];

                    String key=nx+"_"+ny;

                    if(set.contains(key)){
                        break;
                    }
                    x=nx;
                    y=ny;
                }
            }
            maxD=Math.max(maxD,x*x+y*y);
        }
        return maxD;
    }
}