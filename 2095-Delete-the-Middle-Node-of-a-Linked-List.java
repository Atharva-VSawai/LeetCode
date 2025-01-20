class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has one node, return null
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To track the node before the middle node

        // Move fast pointer twice as fast as the slow pointer
        while (fast != null && fast.next != null) {
            prev = slow; // Track the previous node
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        prev.next = slow.next;
        return head;
    }
}
