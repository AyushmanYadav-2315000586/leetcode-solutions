class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int res=0,i=0;
        while(colors[i]==colors[n-1])i++;
        res=Math.max(res,Math.abs(i-(n-1)));
        i=n-1;
        while(colors[0]==colors[i])i--;
        res=Math.max(res,i);

        return res;
    }
}