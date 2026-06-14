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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p2 = reverseFun(slow);       // 'slow' will point to the second middle 
        ListNode p1 = head;        

        int maxSum = 0;
        while (p2 != null) {
            maxSum = Math.max(maxSum, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }

        return maxSum;
    }
    public ListNode reverseFun(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
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