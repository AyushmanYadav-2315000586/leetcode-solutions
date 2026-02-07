class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int a_c=0;
        int b_c=0;
        int del=Integer.MAX_VALUE;

        if(n==1 && (s.charAt(0)=='a'||s.charAt(0)=='b')){
            return 0;
        }

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='a'){
                a_c++;
            }
        }

        for(int i=0; i<n; i++){
            del=Math.min(del,a_c+b_c);
            if(s.charAt(i)=='a'){
                a_c--;
            }
            else if(s.charAt(i)=='b'){
                b_c++;
            }
        }
        del = Math.min(del, a_c + b_c);

        return del;
    }
}







        // Stack<Character> st= new Stack<>();
        // int cnt=0;
        // int n=s.length();
        // for(int i=0; i<n; i++){
        //     if(!st.isEmpty()&&(s.charAt(i)=='a' && st.peek()=='b')){
        //         st.pop();
        //         cnt++;
        //     }else{
        //         st.push(s.charAt(i));
        //     }
        // }
        // return cnt;