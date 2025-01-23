class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;  // Remove node
            } else {
                current = current.next;  // Move to next node
            }
        }
        
        return dummy.next;
    }
}