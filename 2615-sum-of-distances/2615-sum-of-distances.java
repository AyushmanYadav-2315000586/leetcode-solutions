class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long [] arr= new long[n];
        HashMap<Integer,Long> idxSum= new HashMap<>();
        HashMap<Integer,Long> idxCnt= new HashMap<>();

        for(int i=0; i<n; i++){
            long freq=idxCnt.getOrDefault(nums[i],0L);
            long sum=idxSum.getOrDefault(nums[i],0L);

            arr[i]+=freq*i-sum;
            
            idxCnt.put(nums[i],idxCnt.getOrDefault(nums[i],0L)+1);
            idxSum.put(nums[i],idxSum.getOrDefault(nums[i],0L)+i);
        }

        idxCnt.clear();
        idxSum.clear();
        
        for(int i=n-1; i>=0; i--){
            long freq=idxCnt.getOrDefault(nums[i],0L);
            long sum=idxSum.getOrDefault(nums[i],0L);

            arr[i]+=sum-freq*i;
            
            idxCnt.put(nums[i],idxCnt.getOrDefault(nums[i],0L)+1);
            idxSum.put(nums[i],idxSum.getOrDefault(nums[i],0L)+i);
        }

        return arr;
    }
}