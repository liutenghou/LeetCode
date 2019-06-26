import java.util.Arrays;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int index = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                index = i;
                break;
            }
        }
        
        if(index<0) return nums.length;
        
        int pickindex = nums.length-1;
        int subtractby = 0;
        for(int i=index; i<nums.length; i++){
            if(nums[i] != val) break;
            
            //for case [2,2,2]
            if(nums[i] == nums[pickindex]){
                System.out.println("i: " + i + " pickindex: " + pickindex);
                for(int j=i; j<=pickindex; j++){
                    
                    subtractby++;
                }
                break;
            }
            
            subtractby++;
            nums[i] = nums[pickindex];
            pickindex--;
        }
        
        return nums.length-subtractby;
        
    }

}
