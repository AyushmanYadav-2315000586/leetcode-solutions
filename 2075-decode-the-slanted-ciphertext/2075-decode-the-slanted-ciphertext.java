class Solution {
    public String decodeCiphertext(String enc, int rows) {
        StringBuilder sb= new StringBuilder();

        int n=enc.length();

        int cols=n/rows;


        for(int c=0; c<cols; c++){
            int i=0, j=c;

            while(i<rows && j<cols){
                sb.append(enc.charAt(i*cols+j));
                i++;
                j++;
            }
        }

        int end=sb.length()-1;

        while(end>=0 && sb.charAt(end)==' '){
            end--;
        }

        return sb.substring(0,end+1);
    }
}