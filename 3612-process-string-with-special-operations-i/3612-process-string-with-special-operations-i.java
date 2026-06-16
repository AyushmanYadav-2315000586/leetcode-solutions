class Solution {
    public String processStr(String s) {
        StringBuilder res= new StringBuilder();
        int n=s.length();

        for(int i=0; i<n; i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                res.append(s.charAt(i));
            }
            else if(s.charAt(i)=='*'){
                if(res.length()<1){
                    continue;
                }
                res.deleteCharAt(res.length()-1);
            }
            else if(s.charAt(i)=='%'){
                if(res.length()<1){
                    continue;
                }
                res.reverse();
            }
            else{
                if(res.length()<1){
                    continue;
                }
                res.append(res.toString());
            }
        }
        return res.toString();
    }
}