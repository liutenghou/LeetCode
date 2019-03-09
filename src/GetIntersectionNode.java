import java.util.HashSet;

public class GetIntersectionNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// O(n) space
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> hs = new HashSet<>();

		while (headA != null) {
			hs.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (hs.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}

		return null;
	}

	// O(1) space
	public ListNode getIntersectionNodeTricky(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode a = headA;
		ListNode b = headB;

		while (a.next != null) {
			a = a.next;
		}
		while (b.next != null) {
			b = b.next;
		}

		if (a != b)
			return null;

		a = headA;
		b = headB;
		while (true) {
			if (a == b)
				return a;

			if (a.next == null) {
				a = headB;
			} else {
				a = a.next;
			}

			if (b.next == null) {
				b = headA;
			} else {
				b = b.next;
			}

		}

	}

}
