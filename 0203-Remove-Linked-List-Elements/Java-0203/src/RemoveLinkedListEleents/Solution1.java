package RemoveLinkedListEleents;

/**
 * 删除一个结点，需要知道此结点的前驱结点，
 * 由于首结点没有前驱，所以首结点需要特殊处理一下。
 * 代码中第一个 while 循环处理了首结点的数据域的值为 val 这种情况，
 * 注意这里要使用 while 循环而不是 if 语句
 */
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode tmpCell = head;
            head = head.next;
            tmpCell.next = null; // prevent loitering object
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode tmpCell = prev.next;
                prev.next = tmpCell.next;
                tmpCell.next = null; // prevent loitering object
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}
