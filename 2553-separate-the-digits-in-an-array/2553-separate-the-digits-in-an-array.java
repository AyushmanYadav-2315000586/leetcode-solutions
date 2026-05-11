class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            ArrayList<Integer> temp= new ArrayList<>();
            while(nums[i]>0){
                temp.add(nums[i]%10);
                nums[i]/=10;
            }
            Collections.reverse(temp);
            for(int j=0; j<temp.size(); j++){
                res.add(temp.get(j));
            }
        }

        int []r= new int[res.size()];
        for(int i=0; i<res.size(); i++){
            r[i]=res.get(i);
        }
        return r;
    }
}