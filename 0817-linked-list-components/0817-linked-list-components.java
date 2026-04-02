/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set= new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        ListNode curr= head;
        int cnt=0;
        while(curr!=null){
            if(set.contains(curr.val) && (curr.next==null || !set.contains(curr.next.val))){
                cnt++;
            }
            curr=curr.next;
        }
        return cnt;
    }
}






// ---->>> Works only for sorted linked list

// class Solution {
//     public int numComponents(ListNode head, int[] nums) {
//         HashMap<Integer,Integer> map= new HashMap<>();
//         ListNode curr= head;
//         while(curr.next!=null){
//             map.put(curr.val,curr.next.val);
//             curr=curr.next;
//         }

//         Arrays.sort(nums);
//         int cnt=1;
//         for(int i=0; i<nums.length-1; i++){
//             if(!map.containsKey(nums[i]) || map.get(nums[i])!=nums[i+1]){
//                 cnt++;
//             }
//         }

//         return cnt;

//     }
// }