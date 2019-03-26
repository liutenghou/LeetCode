import java.util.Stack;

public class PalindromeLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
	}

	public boolean isPalindrome(ListNode head) {
		// first determine length of linkedlist
		ListNode ln = head;
		int length = 0;
		while (ln != null) {
			length++;
			ln = ln.next;
		}

		int halflength = length / 2;
		Stack<ListNode> s = new Stack<>();
		int count = 1;
		while (head != null) {
			// odd and middle of list
			if (length % 2 != 0 && (count == halflength + 1)) {
				count++;
				head = head.next;
				continue;
			}

			if (count <= halflength) {
				s.push(head);
			} else {
				ListNode p = s.pop();
				if (p.val != head.val)
					return false;
			}

			count++;
			head = head.next;
		}

		return true;

	}
}
