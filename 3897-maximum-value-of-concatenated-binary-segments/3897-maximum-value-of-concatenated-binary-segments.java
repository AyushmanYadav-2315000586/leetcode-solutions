class Solution {
    long mod=1_000_000_007;
    public int maxValue(int[] nums1, int[] nums0) {
        long res=0;
        int n=nums1.length;
        int [][]seg= new int[n][2];

        for(int i=0; i<n; i++){
            seg[i][0]=nums1[i];
            seg[i][1]=nums0[i];
        }

        Arrays.sort(seg,(a,b)->{
            boolean aOnes=(a[1]==0);
            boolean bOnes=(b[1]==0);

            if(aOnes && !bOnes) return -1;
            if(!aOnes && bOnes) return 1;
            
            boolean aZ=(a[0]==0);
            boolean bZ=(b[0]==0);

            if(aZ && !bZ) return 1;
            if(!aZ && bZ) return -1;

            if(a[0]!=b[0]){
                return Integer.compare(b[0],a[0]);
            }
            else{
                return Integer.compare(a[1],b[1]);
            }
        });

        for(int[]s: seg){
            int one=s[0];
            int zero=s[1];

            for(int i=0; i<one; i++){
                res=(res*2+1)%mod;
            }
            for(int i=0; i<zero; i++){
                res=(res*2)%mod;
            }
        }
        return (int)res;
    }
}