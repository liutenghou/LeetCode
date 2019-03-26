import java.util.*;

public class ReverseLinkedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode head = rll.new ListNode(1);
		head.next = rll.new ListNode(2);
		head.next.next = rll.new ListNode(3);
		head.next.next.next = rll.new ListNode(4);
		head.next.next.next.next = rll.new ListNode(5);
		ListNode reversed = reverseListIterative(head);
		
		while(reversed != null) {
			System.out.println(reversed.val);
			reversed = reversed.next;
		}
	}

	// iterative
	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return head;

		List<ListNode> l = new ArrayList<>();
		while (head != null) {
			l.add(head);
			head = head.next;
		}
		Collections.reverse(l);

		ListNode resultHead = l.get(0);
		ListNode temp = resultHead;
		for (int i = 1; i < l.size(); i++) {
			temp.next = l.get(i);
			temp = temp.next;
		}
		temp.next = null;

		return resultHead;
	}

	//More efficient O(n), O(1) space
	public static ListNode reverseListIterative(ListNode head) {
		// efficient iterative
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;

		while (head != null) {
			// save next;
			next = head.next; 
			//set current and current next
			curr = head;
			curr.next = prev;
			//advance pointers
			prev = curr;
			head = next;
		}

		return curr;
	}
	
	//recursive
	//efficient recursive
    public ListNode reverseListRecursive(ListNode head) {
		if(head == null || head.next == null) return head;
        
        ListNode newHead = reverseList(head.next); //retrieves last node;
        
        head.next.next = head; //sets the next node's next to point backward at self
        head.next = null; //sets last node to null, otherwise this next is overwritten by recursive calls
        
        return newHead;
	}

}
