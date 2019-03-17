import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLongestSubstring(String s) {

		int longest = 0;
		HashSet<Character> hs = new HashSet<>();
		char[] sarr = s.toCharArray();

		for (int i = 0; i < sarr.length; i++) {
			int currlongest = 0;
			for (int j = i; j < sarr.length; j++) {
				if (!hs.contains(sarr[j])) {
					hs.add(sarr[j]);
					currlongest++;
					if (currlongest > longest)
						longest = currlongest;
				} else {
					hs.clear();
					break;
				}
			}
		}

		return longest;

	}

}
