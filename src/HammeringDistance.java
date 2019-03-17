
public class HammeringDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1;
		int y = 4;
		System.out.println(hammingDistance(x, y));
	}

	
	//The Hamming distance between two integers is the 
	//number of positions at which the corresponding bits are different.
	public static int hammingDistance(int x, int y) {
		int count = 0;
		int z = x ^ y;
		for (int i = 0; i < 32; i++) {
			if ((z & 1) == 1)
				count++;
			z = z >> 1;
		}

		return count;
	}

}
