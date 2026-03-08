class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<nums.length; i++){
            char ch=nums[i].charAt(i);
            sb.append((ch=='0')?'1':'0');
        }
        return sb.toString();
    }
}



// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         Set<Integer> st= new HashSet<>();

//         for(String num: nums){
//             st.add(Integer.parseInt(num,2));
//         }

//         int n=nums.length;
//         String res="";
//         for(int i=0; i<=n; i++){
//             if(!st.contains(i)){
//                 res=Integer.toBinaryString(i);
//                 while(res.length()<n){
//                     res="0"+res;
//                 }
//                 return res;
//             }
//         }
//         return "";
//     }
// }