class Solution {
    public int maximumProduct(int[] nums) {
        int mx1=-1000, mx2=-1000, mx3=-1000, mn1=0, mn2=0;

        for(int num: nums){
            if(mx1<num){
                mx3=mx2;
                mx2=mx1;
                mx1=num;
            }
            else if(mx2<num){
                mx3=mx2;
                mx2=num;
            }
            else if(mx3<num){
                mx3=num;
            }

            if(mn1>num){
                mn2=mn1;
                mn1=num;
            }
            else if(mn2>num){
                mn2=num;
            }
        }

        return Math.max(mx1*mx2*mx3, mn1*mn2*mx1);
    }
}