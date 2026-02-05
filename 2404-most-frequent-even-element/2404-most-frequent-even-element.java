class Solution {
    public int mostFrequentEven(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<n; i++){
            if(nums[i]%2==0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        if(map.size()<1){
            return -1;
        }
        int num=0;
        int maxFreq=0;
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                continue;
            }
            int freq=map.get(nums[i]);
            if(freq>maxFreq){
                num=nums[i];
                maxFreq=freq;
            }
            else if(freq==maxFreq){
                num=Math.min(num,nums[i]);
            }
        }
        return num;

    }
}