
public class MaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t1 = { 7, 1, 5, 3, 6, 4 };
		int[] t2 = { 2, 4, 1 };
		int[] t3 = { 4, 1, 2 };
		int[] t4 = { 7, 2, 4, 1 };
		
		System.out.println(maxProfitLinear(t2));

	}

	// O(n^2)
	public static int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			int lval = prices[i];
			int hval = lval;
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] > hval) {
					hval = prices[j];
				}
			}

			if ((hval - lval) > max)
				max = (hval - lval);

		}
		return max;
	}

	// O(n)
	public static int maxProfitLinear(int[] prices) {
		if (prices.length < 2)
			return 0;

		int min = Integer.MAX_VALUE;
		int maxdiff = 0;

		for (int i = 0; i < prices.length; i++) {

			int curdiff = prices[i] - min;
			if (curdiff > 0) {
				if (curdiff > maxdiff) {
					maxdiff = curdiff;
				}
			}

			if (prices[i] < min)
				min = prices[i];

		}

		return maxdiff;
	}

}
