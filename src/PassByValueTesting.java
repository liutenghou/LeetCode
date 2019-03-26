import java.util.*;

public class PassByValueTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		Integer j = 1;
		int[] k = {3,6};
		int[] y = k.clone();
		boolean b = true;
		List<Integer> l = new ArrayList<>();
//		addToList(l);
//		System.out.println(l.toString());
		transform(k);
//		tofalse(b);
		System.out.println(Arrays.toString(k));
		System.out.println(Arrays.toString(y));
	}
	
	public static void transform(int[] i) {
		i[0] = 1;
	}
	
	public static void tofalse(boolean b) {
		b = false;
	}
	
	public static void addToList(List<Integer> list) {
		list.add(2);
	}

}
