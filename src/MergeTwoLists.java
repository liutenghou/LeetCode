
public class MergeTwoLists {

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoLists mtl = new MergeTwoLists();
		ListNode l1 = mtl.new ListNode(1);
		ListNode l2 = mtl.new ListNode(2);
		ListNode ln = mtl.recursiveMerge(l1, l2);
		while(ln != null) {
			System.out.println(ln.val);
			ln = ln.next;
		}
	}
	
	public ListNode recursiveMerge(ListNode l1, ListNode l2) {
		//termination conditions
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		if(l1.val < l2.val) {
			l1.next = recursiveMerge(l1.next, l2);
			return l1;
		}else {
			l2.next = recursiveMerge(l1, l2.next);
			return l2;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		ListNode head = new ListNode(0);
		ListNode temp = head;
		boolean first = true;

		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {

				if (l1.val < l2.val) {
					if (first) {
						head = new ListNode(l1.val);
						temp = head;
					} else {
						temp.next = new ListNode(l1.val);
						temp = temp.next;
					}
					l1 = l1.next;
				} else {
					if (first) {
						head = new ListNode(l2.val);
						temp = head;
					} else {
						temp.next = new ListNode(l2.val);
						temp = temp.next;
					}
					l2 = l2.next;
				}
			} else if (l1 != null && l2 == null) {
				if (first) {
					head = l1;
					break;
				} else {
					temp.next = new ListNode(l1.val);
					temp = temp.next;
					l1 = l1.next;
				}
			} else if (l1 == null && l2 != null) {
				if (first) {
					head = l2;
					break;
				} else {
					temp.next = new ListNode(l2.val);
					temp = temp.next;
					l2 = l2.next;
				}
			}
			first = false;
		}

		return head;
	}
}
