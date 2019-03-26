
public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] nums) {
        if(nums.length<1) return 0;
        int lefti=0;
        
        for(int j=1; j<nums.length; j++){
            int jnum = nums[j];
            int inum = nums[lefti];
            if(inum == jnum){
                
            }else{
                lefti++;
                nums[lefti] = jnum;
            }
        }
        
        return lefti+1;
    }

}
