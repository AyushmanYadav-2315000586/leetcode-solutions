class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st= new Stack<>();
        int cnt=0;
        int n=s.length();
        for(int i=0; i<n; i++){
            if(!st.isEmpty()&&(s.charAt(i)=='a' && st.peek()=='b')){
                st.pop();
                cnt++;
            }else{
                st.push(s.charAt(i));
            }
        }
        return cnt;
    }
}