class Solution {
    public int bitwiseComplement(int n) {
        String bs=Integer.toBinaryString(n);
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<bs.length(); i++){
            if(bs.charAt(i)=='0'){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }
        String s=sb.toString();
        int num=Integer.parseInt(s,2);
        return num;
    }
}