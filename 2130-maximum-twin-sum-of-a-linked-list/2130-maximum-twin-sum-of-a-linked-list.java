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
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode curr=rev(slow);
        int res=0;
        while(curr!=null){
            res=Math.max(res,head.val+curr.val);
            curr=curr.next;
            head=head.next;
        }
        return res;
    }

    ListNode rev(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }
}

















// class Solution {
//     public int pairSum(ListNode head) {
//         Stack<Integer> st= new Stack<>();
//         ListNode dum=head;
//         while(dum!=null){
//             st.push(dum.val);
//             dum=dum.next;
//         }
//         int res=0;
//         int n=st.size();
//         int i=0;
//         while(i<n/2){
//             int v=st.pop();
//             res=Math.max(res,head.val+v);
//             i++;
//             head=head.next;
//         }
//         return res;
//     }
// }









// class Solution {
//     public int pairSum(ListNode head) {
//         ArrayList<Integer> num= new ArrayList<>();
//         while(head!=null){
//             num.add(head.val);
//             head=head.next;
//         }
//         int res=0;
//         int n=num.size();
//         for(int i=0; i<n/2; i++){
//             res=Math.max(res,num.get(i)+num.get(n-1-i));
//         }
//         return res;
//     }
// }