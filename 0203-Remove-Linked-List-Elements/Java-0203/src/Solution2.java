public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        /* 设置虚拟头结点 */
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode tmpCell = prev.next;
                prev.next = tmpCell.next;
                tmpCell.next = null; // prevent loitering object
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }
}
