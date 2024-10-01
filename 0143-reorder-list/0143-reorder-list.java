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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {  
            slow = slow.next;           // finding the first mid
            fast = fast.next.next;
        }

        ListNode j = slow.next; 
        slow.next = null;
        j = reverseFun(j);              // reverse the end part of list   

        ListNode i = head;
        while (i != null && j != null) {
            ListNode ahead_i = i.next;
            i.next = j;
            i = ahead_i;

            ListNode ahead_j = j.next;
            j.next = i;
            j = ahead_j;
        }  

        return;                                        
    }
    public ListNode reverseFun(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode ahead = null;

        while (curr != null) {
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }

        return prev;
    }
}