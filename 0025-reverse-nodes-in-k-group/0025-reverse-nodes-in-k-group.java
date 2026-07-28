class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        
        // Step 1: check if k nodes are available
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        
        if (count < k) return head; // not enough nodes, leave as is
        
        // Step 2: reverse first k nodes
        ListNode prev = reverseKGroup(node, k); // node = start of next group (already processed)
        ListNode curr = head;
        
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev; // new head of this reversed group
    }
}