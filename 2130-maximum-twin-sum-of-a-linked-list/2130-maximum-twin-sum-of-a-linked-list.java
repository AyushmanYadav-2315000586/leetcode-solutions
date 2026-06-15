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
    public int pairSum(ListNode head) {
        ArrayList<Integer> num= new ArrayList<>();
        while(head!=null){
            num.add(head.val);
            head=head.next;
        }
        int res=0;
        int n=num.size();
        for(int i=0; i<n/2; i++){
            res=Math.max(res,num.get(i)+num.get(n-1-i));
        }
        return res;
    }
}