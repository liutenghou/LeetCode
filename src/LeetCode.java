import java.util.Arrays;
import java.util.Collections;

public class LeetCode {

	public static void main(String[] args) {
		LeetCode lc = new LeetCode();
		
//		[2,4,3]
//		[5,6,4]
//		ListNode l1 = lc.new ListNode(2);
//		ListNode l1_1 = lc.new ListNode(4);
//		ListNode l1_2 = lc.new ListNode(3);
//		
//		l1.next = l1_1;
//		l1_1.next = l1_2;
//		
//		ListNode l2 = lc.new ListNode(5);
//		ListNode l2_1 = lc.new ListNode(6);
//		
//		l2.next = l2_1;
//		
//		ListNode ret = lc.addTwoNumbers(l1, l2);
//		ListNode temp = ret;
//		while(temp != null) {
//			System.out.print(String.valueOf(temp.val + ","));
//			temp = temp.next;
//		}
		
		//coinChange
		int[] coins = {1, 2, 5};
		int amount = 11;
		
//		System.out.println(lc.coinChange(coins, amount));
		//4173
		int[] houses = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		//house robber
		System.out.println(lc.rob(houses));
	}
	
	int[] memo;
	public int rob(int[] nums) {
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return rob(nums, nums.length-1);
	}
	
	public int rob(int[] nums, int topI) {
		if(topI < 0) {
			return 0;
		}	
		int topN = nums[topI];
		if(memo[topI] > 0) {
			return memo[topI];
		}
		
		int max;
		if(topN < 1) {
			max = rob(nums, topI-1);
		}else {
			max = Math.max(topN + rob(nums, topI-2), rob(nums, topI-1));
		}
		memo[topI] = max;
		
		return max;
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
