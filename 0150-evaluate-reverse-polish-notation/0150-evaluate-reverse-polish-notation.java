class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st= new Stack<>();

        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num2=st.pop();
                int num1=st.pop();
                if(tokens[i].equals("+")){
                    st.push(num1+num2);
                }
                else if(tokens[i].equals("-")){
                    st.push(num1-num2);
                }
                else if(tokens[i].equals("*")){
                    st.push(num1*num2);
                }
                else{
                    st.push(num1/num2);
                }
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}