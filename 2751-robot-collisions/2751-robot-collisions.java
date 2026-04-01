class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] heal, String dir) {
        int n=pos.length;
        List<Integer> res= new ArrayList<>();
        Stack<Integer> st= new Stack<>();
        Integer [] idx= new Integer[n];

        for(int i=0; i<n;i++){
            idx[i]=i;
        }

        Arrays.sort(idx,(i,j)->Integer.compare(pos[i],pos[j]));


        for(int curr: idx){
            if(dir.charAt(curr)=='R'){
                st.push(curr);
            }
            else{
                while(!st.isEmpty() && heal[curr]>0){
                    int top=st.pop();

                    if(heal[top]>heal[curr]){
                        heal[top]-=1;
                        heal[curr]=0;
                        st.push(top);
                    }
                    else if(heal[top]<heal[curr]){
                        heal[curr]-=1;
                        heal[top]=0;
                    }
                    else{
                        heal[curr]=0;
                        heal[top]=0;  
                    }
                }
            }
        }


        for(int i=0; i<n; i++){
            if(heal[i]>0){
                res.add(heal[i]);
            }
        }
        return res;
    }
}