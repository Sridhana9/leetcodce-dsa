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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create two pointers, both starting at head
        ListNode fastp = head;
        ListNode slowp = head;

        // Move fastp n steps ahead
        for (int i = 0; i < n; i++) {
            fastp = fastp.next;
        }

        // If fastp is null, we need to remove the head node
        if (fastp == null) {
            return head.next;
        }

        // Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Skip the node to be deleted
        slowp.next = slowp.next.next;

        return head;
    }
}
