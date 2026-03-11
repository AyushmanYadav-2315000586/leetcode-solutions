class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            while(nums[i]>0 && nums[i]<=n && (nums[nums[i]-1]!=nums[i])){
                int ci=nums[i]-1;
                int temp=nums[i];
                nums[i]=nums[ci];
                nums[ci]=temp;
            }
        }    
        for(int i=0; i<n; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}


// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         HashSet<Integer> set= new HashSet<>();
//         for(int num: nums){
//             set.add(num);
//         }
//         for(int i=1; i<=nums.length; i++){
//             if(!set.contains(i)){
//                 return i;
//             }
//         }
//         return nums.length+1;
//     }
// }