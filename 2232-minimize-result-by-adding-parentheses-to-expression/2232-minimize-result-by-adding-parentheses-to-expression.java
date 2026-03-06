class Solution {
    public String minimizeResult(String expression) {
        int plus= expression.indexOf("+");
        int min=Integer.MAX_VALUE;
        String res="";

        for(int i=0; i<plus; i++){
            for(int j=plus+1; j<expression.length(); j++){

                int l=(i==0)?1: Integer.parseInt(expression.substring(0,i));
                int mid1= Integer.parseInt(expression.substring(i,plus));
                int mid2= Integer.parseInt(expression.substring(plus+1,j+1));
                int r=(j==expression.length()-1)?1: Integer.parseInt(expression.substring(j+1));

                int val=l*(mid1+mid2)*r;

                if(val<min){
                    min=val;
                    res=expression.substring(0,i)+"("+expression.substring(i,j+1)+")"+expression.substring(j+1);
                }
            }
        }
        return res;
    }

}