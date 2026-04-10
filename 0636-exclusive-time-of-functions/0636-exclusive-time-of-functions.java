class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st= new Stack<>();
        int []res= new int[n];
        int prev=0;
        for(String log:logs){
            String[]parts= log.split(":");
            int id=Integer.parseInt(parts[0]);
            String pro = parts[1];
            int time=Integer.parseInt(parts[2]);

            if(pro.equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()]+=time-prev;
                }
                st.push(id);
                prev=time;
            }
            else{
                res[st.pop()]+=time-prev+1;
                prev=time+1;
            }
        }
        return res;
    }
}