/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        int idx=peakIndexInMountainArray(mountainArr);
        int res_idx=bs(mountainArr,0,idx,target);
        if(res_idx!=-1){
            return res_idx;
        }
        res_idx=rbs(mountainArr,idx+1,n-1,target);
        return res_idx;
    }
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int l=0;
        int r=mountainArr.length()-1;
        while(l<r){
            int mid=(l+r)/2;
            if(mid>0 && mid<r && mountainArr.get(mid)>mountainArr.get(mid-1) && mountainArr.get(mid)>mountainArr.get(mid+1)){
                return mid;
            }
            else if(mid>0 && mountainArr.get(mid)<mountainArr.get(mid-1)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    int bs(MountainArray mountainArr, int l, int r, int target){
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
    int rbs(MountainArray mountainArr, int l, int r, int target){
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)>target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
}