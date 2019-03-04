import java.util.Arrays;
import java.util.HashMap;

public class NumberOfLines {

	public static void main(String[] args) {

		int[] i = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10, 10, 10 };
		String s = "abcdefghijklmnopqrstuvwxyz";
		int[] results = numberOfLines2(i, s);
		System.out.println(Arrays.toString(results));

	}
	
	public static int[] numberOfLines2(int[] widths, String S) {
		 
        int line = 1;
        int width = 0;
        
        for(char c: S.toCharArray()){
            int w = widths[c-'a'];
            if(w + width > 100){
                line++;
                width = 0;
            }
            width += w;
        }
        return new int[]{line, width};
	}

	public static int[] numberOfLines1(int[] widths, String S) {

		// array with alphabet
		HashMap<Character, Integer> a = new HashMap<>();
		a.put('a', 0);
		a.put('b', 1);
		a.put('c', 2);
		a.put('d', 3);
		a.put('e', 4);
		a.put('f', 5);
		a.put('g', 6);
		a.put('h', 7);
		a.put('i', 8);
		a.put('j', 9);
		a.put('k', 10);
		a.put('l', 11);
		a.put('m', 12);
		a.put('n', 13);
		a.put('o', 14);
		a.put('p', 15);
		a.put('q', 16);
		a.put('r', 17);
		a.put('s', 18);
		a.put('t', 19);
		a.put('u', 20);
		a.put('v', 21);
		a.put('w', 22);
		a.put('x', 23);
		a.put('y', 24);
		a.put('z', 25);

		Integer[] lines = new Integer[1000];
		Arrays.fill(lines, 0);
		int linesI = 0;

		// number of lines with character from S
		// iterate over letters in S
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			Integer wi = a.get(c);

			Integer len = widths[wi];
			Integer line = lines[linesI];

			if (len + line > 100) {
				linesI++;
			}
			lines[linesI] += len;

			System.out.println("linesI: " + linesI + " lines[linesI]: " + lines[linesI]);
		}
		// width used by last line

		return new int[] { linesI + 1, lines[linesI] };

	}

}
