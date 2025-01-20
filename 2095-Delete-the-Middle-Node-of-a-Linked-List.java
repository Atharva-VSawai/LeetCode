class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) { // single element list
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 1 2 3 4 5
        // slow -> 2, 3 -> slow.next, 4 ->
        slow.next = slow.next.next;
        return head;
    }
}

