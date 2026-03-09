class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int l_max=0;
        int r_max=0;
        int l=0;
        int r=n-1;
        int total=0;
        while(l<r){
            if(arr[l]<=arr[r]){
                if(l_max>arr[l]){
                    total+=l_max-arr[l];
                }
                else{
                    l_max=arr[l];
                }
                l++;
            }
            else{
                if(r_max>arr[r]){
                    total+=r_max-arr[r];
                }
                else{
                    r_max=arr[r];
                }
                r--;
            }
        }
        return total;
    }
}

// int left[]=new int[height.length];
//         int right[]=new int[height.length];
//         left[0]=height[0];
//         for(int i=1;i<height.length;i++)
//         {
//             left[i]=Math.max(left[i-1],height[i]);
//         }
//         right[right.length-1]=height[height.length-1];
//         for(int i=height.length-2;i>=0;i--)
//         {
//             right[i]=Math.max(right[i+1],height[i]);
//         }
//         int ans=0;
//         for(int i=0;i<height.length;i++)
//         {
//             ans+=Math.min(left[i],right[i])-height[i];
//         }
//         return ans;