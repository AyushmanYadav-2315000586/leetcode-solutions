class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();

        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){

            if(map.containsKey(nums[i])){
                min=Math.min(Math.abs(i-map.get(nums[i])),min);
            }

            int rev=rev(nums[i]);
            map.put(rev,i);
        }
        return min==Integer.MAX_VALUE?-1:min;

    }

    int rev(int n){
        int ans=0;

        while(n>0){
            int rem=n%10;
            ans=(ans*10)+rem;
            n/=10;
        }
        return ans;
    }
}