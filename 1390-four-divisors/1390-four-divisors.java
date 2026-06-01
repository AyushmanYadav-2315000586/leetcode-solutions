class Solution {
    public int sumFourDivisors(int[] nums) {
        int res=0;

        for(int num:nums){
            res+=sum(num);
        }

        return res;
    }

    int sum(int num){
        int div=0;
        int s=0;
        for(int i=1; i*i<=num; i++){
            if(num%i==0){
                int ot=num/i;

                if(ot==i){
                    div+=1;
                    s+=i;
                }
                else{
                    div+=2;
                    s+=(i+ot);
                }
            }

            if(div>4)return 0;
        }

        return div==4?s:0;
    }
}