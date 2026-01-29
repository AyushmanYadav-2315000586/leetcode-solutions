class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        subset(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    public void subset(int [] nums, int idx, List<Integer> arr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(arr));
        for(int i=idx; i<nums.length; i++){
            arr.add(nums[i]);
            subset(nums, i+1, arr, ans);
            arr.remove(arr.size()-1);
        }
    }
}