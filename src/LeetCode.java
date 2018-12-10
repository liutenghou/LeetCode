
public class LeetCode {

	public static void main(String[] args) {
		LeetCode lc = new LeetCode();
		
//		[2,4,3]
//		[5,6,4]
		ListNode l1 = lc.new ListNode(2);
		ListNode l1_1 = lc.new ListNode(4);
		ListNode l1_2 = lc.new ListNode(3);
		
		l1.next = l1_1;
		l1_1.next = l1_2;
		
		ListNode l2 = lc.new ListNode(5);
		ListNode l2_1 = lc.new ListNode(6);
		
		l2.next = l2_1;
		
		ListNode ret = lc.addTwoNumbers(l1, l2);
		ListNode temp = ret;
		while(temp != null) {
			System.out.print(String.valueOf(temp.val + ","));
			temp = temp.next;
		}
		
	}
	
	private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { 
    	  val = x; 
      }
	}
	
	ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode retHead = null;
        ListNode temp = null;
        int carryOne = 0;
        int val1 = 0;
        int val2 = 0;
        int sumVal = 0;
        
        //add values
        while(l1 != null || l2 != null || carryOne == 1) {
        	if(l1 != null) {
        		val1 = l1.val;
        		l1 = l1.next;
        	}else {
        		val1 = 0;
        	}
        	if(l2 != null) {
        		val2 = l2.val;
        		l2 = l2.next;
        	}else {
        		val2 = 0;
        	}
        	
        	sumVal = val1 + val2 + carryOne;
        	if(sumVal >= 10) {
        		carryOne = 1;
        		sumVal = sumVal % 10;
        	}else {
        		carryOne = 0;
        	}
        	
        	if(retHead == null) {
        		retHead = new ListNode(sumVal);
        		temp = retHead;
        	}else {
        		temp.next = new ListNode(sumVal);
        		temp = temp.next;
        	}
        	
        }
        return retHead;
		
    }

}
