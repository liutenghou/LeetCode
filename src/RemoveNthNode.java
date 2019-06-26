
public class RemoveNthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;

		int length = findLength(head);
		int removeNth = length - n;
		if (removeNth == 0)
			return head.next;

		ListNode temp = head;

		int i = 0;
		while (temp.next != null) {
			if (i + 1 == removeNth) {
				temp.next = temp.next.next;
				i += 2;
				continue;
			}

			i++;
			temp = temp.next;
		}

		return head;
	}

	public int findLength(ListNode head) {
		if (head == null)
			return 0;
		return 1 + findLength(head.next);
	}

}
