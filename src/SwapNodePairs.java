import java.util.*;

public class SwapNodePairs {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode ln = swapHelper(head, head.next);

		return ln;
	}

	public ListNode swapHelper(ListNode first, ListNode second){
        ListNode l = null;
        if(second.next != null && second.next.next != null) {
            System.out.println("both not null second.next.val: " + second.next.val + " second.next.next.val: " + second.next.next.val);
            l = swapHelper(second.next, second.next.next);
        } else if(second.next != null && second.next.next == null) {
            System.out.println("nextnext is null, second.next.val" + second.next.val);
            l = second.next;
        }
        
        ListNode temp = second;
        second = first;
        first = temp;
        first.next = second;
        second.next = l;
        System.out.println("swapped first: " + first.val + " with second: " + second.val);
        if(second.next != null) System.out.println("second.next.val: " + second.next.val);
        return first;
    }

}
