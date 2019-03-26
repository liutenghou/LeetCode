import java.util.*;

public class UnsortedSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//horrible solution, time limit exceeded
	public int findUnsortedSubarray(int[] nums) {
		int maxlength = 0;

		for (int i = 0; i < nums.length; i++) {
			int left = nums[i];
			List<Integer> l = new ArrayList<Integer>();

			for (int j = i; j < nums.length; j++) {
				l.add(nums[j]);

				List<Integer> ltemp = new ArrayList<Integer>(l);
				Collections.sort(ltemp);
				if (ltemp.get(0) != l.get(0) && ltemp.get(ltemp.size() - 1) != l.get(l.size() - 1)) {
					if (l.size() > maxlength)
						maxlength = l.size();
				}
			}
		}

		return maxlength;
	}
	
	//just needed to sort once, nlogn
	public int findUnsortedSubarraySort(int[] nums) {
        int max = 0;
        if(nums.length < 2) return max;
        
        int[] numsorted = nums.clone();
        Arrays.sort(numsorted);
        
        int starti = -1;
        int endi = -1;
        boolean alreadysorted = true;
        for(int i=0; i<nums.length; i++){
            if(numsorted[i] != nums[i]){
                alreadysorted = false;
                if(starti < 0) starti = i;
                endi = i;
            }
        }
        
        if(!alreadysorted) max = endi-starti+1;
        return max;
    }

}
