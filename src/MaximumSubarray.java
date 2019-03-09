
public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray2(input));
		
	}
	
	//O(n^2)
	public static int maxSubArray1(int[] nums) {
        //maximum inefficiency
        int largestSum = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            int left = nums[i];
            int temp = left;
                
            if(temp > largestSum) largestSum = temp;
            
            for(int j=i+1; j<nums.length; j++){
                temp += nums[j];
                if(temp > largestSum) largestSum = temp;
            }
        }
        return largestSum;
    }  
	
	//DP O(n) solution
	public static int maxSubArray2(int[] nums) {
		int max = nums[0];
		int maxPrevious = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			int currentSum = maxPrevious + nums[i];
			if(currentSum > nums[i]) {
				maxPrevious = currentSum;
			}else {
				maxPrevious = nums[i];
			}
			
			if(maxPrevious > max) max = maxPrevious;
		}
		
		return max;
	}
	

}
