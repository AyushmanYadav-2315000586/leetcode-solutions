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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode t= head;
        int len=1;

        while(t.next!=null){
            t=t.next;
            len++;
        }

        t.next=head;
        ListNode newT=t;
        k=k%len;
        int hC=len-k;
        for(int i=0; i<hC; i++){
            newT=newT.next;
        }
        ListNode newH=newT.next;
        newT.next=null;

        return newH;
    }
}