import java.util.*;

public class HasCycle {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n) space complexity
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> hs = new HashSet<>();

		while (head != null) {
			if (!hs.contains(head)) {
				hs.add(head);
			} else {
				return true;
			}
			head = head.next;
		}

		return false;
	}

	//O(1) space complexity
	public boolean hasCycleTortoiseHare(ListNode head) {
		if (head == null)
			return false;

		// Floyd's Tortoise and Hare
		ListNode tortoise;
		if (head.next != null) {
			tortoise = head.next;
		} else {
			return false;
		}

		ListNode hare;
		if (head.next.next != null) {
			hare = head.next.next;
		} else {
			return false;
		}

		while (hare != null || tortoise != null) {
			if (tortoise == hare)
				return true;

			if (tortoise.next != null) {
				tortoise = tortoise.next;
			} else {
				return false;
			}

			if (hare.next != null && hare.next.next != null) {
				hare = hare.next.next;
			} else {
				return false;
			}

		}

		return false;
	}

}
