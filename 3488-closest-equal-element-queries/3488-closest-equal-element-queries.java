class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        int []mD= new int[n];
        Arrays.fill(mD,n);

        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i=0; i<2*n; i++){
            int idx=i%n;
            int val=nums[idx];

            if(map.containsKey(val)){
                int prev=map.get(val);
                int dist=i-prev;
                mD[idx]=Math.min(mD[idx],dist);
                mD[prev%n]=Math.min(mD[prev%n],dist);
            }

            map.put(val,i);
        }

        List<Integer> res= new ArrayList<>();

        for(int q: queries){
            int d=mD[q];
            res.add(d==n?-1:d);
        }
        return res;
    }
}