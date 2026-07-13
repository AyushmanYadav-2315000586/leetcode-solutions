class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();

        int r=1;
        int sort[]=arr.clone();
        Arrays.sort(arr);

        for(int num: arr){
            if(!map.containsKey(num)){
                map.put(num,r++);
            }
        }
        int n=arr.length;
        int []nums=new int[n]; 
        for(int i=0; i<n; i++){
            nums[i]=map.get(sort[i]);
        }
        return nums;
    }
}