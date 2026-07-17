class Solution {
    public long gcdSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        int []preGD= new int[n];
        for(int i=0; i<n; i++){
            max=Math.max(max,nums[i]);
            preGD[i]=gcd(nums[i],max);
        }

        Arrays.sort(preGD);
        int i=0,j=n-1;
        long sum=0;
        while(i<j){
            int val=gcd(preGD[i],preGD[j]);
            sum+=val;
            i++;
            j--;
        }
        return sum;
    }
    int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}