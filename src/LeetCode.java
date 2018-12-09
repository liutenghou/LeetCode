
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
        
        ListNode retHead = new ListNode(0);
        int carryOne = 0;
        boolean isFirst = true;
        ListNode temp = retHead;
        int sumVal;
        
        //add values
        while(l1 != null || l2 != null || carryOne == 1) {
        	if(isFirst) {
        		if(l1 == null && l2 != null) {
                	temp = new ListNode(l2.val);
                	l2 = l2.next;
                }else if(l1 != null && l2 == null) {
                	temp = new ListNode(l1.val);
                	l1 = l1.next;
                	carryOne = 0;
                }else {
                	sumVal = l1.val + l2.val + carryOne;
                	if(sumVal > 9) {
                		carryOne = 1;
                		sumVal = sumVal % 10;
                	}else {
                		carryOne = 0;
                	}
                	temp = new ListNode(sumVal);
                	System.out.println("l1: " + l1.val + " l2: " + l2.val);
                	l1 = l1.next;
                	l2 = l2.next;
                	
                }
        		
        		retHead = temp;
        		isFirst = false;
        	}else {
        		if(l1 == null && l2 != null) {
        			sumVal = l2.val + carryOne;
        			if(sumVal > 9) {
                		carryOne = 1;
                		sumVal = sumVal % 10;
                	}else {
                		carryOne = 0;
                	}
        			
                	temp.next = new ListNode(sumVal);
                	l2 = l2.next;
                }else if(l1 != null && l2 == null) {
                	sumVal = l1.val + carryOne;
                	if(sumVal > 9) {
                		carryOne = 1;
                		sumVal = sumVal % 10;
                	}else {
                		carryOne = 0;
                	}
                	temp.next = new ListNode(sumVal);
                	l1 = l1.next;
                }else if(l1 != null && l2 != null){
                	sumVal = l1.val + l2.val + carryOne;
                	if(sumVal > 9) {
                		carryOne = 1;
                		sumVal = sumVal % 10;
                	}else {
                		carryOne = 0;
                	}
                	temp.next = new ListNode(sumVal);
                	System.out.println("l1: " + l1.val + " l2: " + l2.val);
                	l1 = l1.next;
                	l2 = l2.next;
                	
                }else {
                	if(carryOne == 1) {
                    	temp.next = new ListNode(1);
                    }
                	carryOne = 0;
                }
        		temp = temp.next;
        		
        	}
        	
        	
        }
        return retHead;
		
    }

}
