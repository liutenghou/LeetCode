import java.util.*;

public class JewelsInStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Runtime: 8 ms, faster than 77.47% of Java online submissions for Jewels and
	// Stones.
	// Memory Usage: 38.1 MB, less than 11.42% of Java online submissions for Jewels
	// and Stones.
	public int numJewelsInStones(String J, String S) {
		HashMap<Character, Integer> h = new HashMap<>();

		char[] schar = S.toCharArray();
		char[] jchar = J.toCharArray();

		for (char c : schar) {
			if (!h.containsKey(c)) {
				h.put(c, 1);
			} else {
				h.replace(c, h.get(c) + 1);
			}
		}

		int count = 0;
		for (char c : jchar) {
			if (h.containsKey(c)) {
				count += h.get(c);
			}
		}

		return count;
	}

	//Runtime: 8 ms, faster than 77.47% of Java online submissions for Jewels and Stones.
	//Memory Usage: 37.9 MB, less than 78.07% of Java online submissions for Jewels and Stones.
	public int numJewelsInStonesBrute(String J, String S) {

		char[] schar = S.toCharArray();
		char[] jchar = J.toCharArray();

		int count = 0;
		for (char s : schar) {
			for (char j : jchar) {
				if (j == s)
					count++;
			}
		}

		return count;
	}

}
