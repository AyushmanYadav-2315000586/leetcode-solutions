class Solution {
    public int[] sortByBits(int[] arr) {
        Integer nums[]= new Integer[arr.length];
        for(int i=0; i<arr.length; i++){
            nums[i]=arr[i];
        }
        Arrays.sort(nums, (a,b)->{
            int cA= Integer.bitCount(a);
            int cB= Integer.bitCount(b);
            if(cA==cB){
                return a-b;
            }
            return cA-cB;
        });

        for(int i=0; i<arr.length; i++){
            arr[i]=nums[i];
        }
        return arr;
    }
}