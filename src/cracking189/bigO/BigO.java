package cracking189.bigO;

public class BigO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutation("abcd");
//		System.out.println("abcd".substring(0, 0)+"="); //空字串
	}

	
	static void permutation(String str){
		permutation(str, "");
	}
	
	static void  permutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i+1);
				System.out.println("rem = " + rem + " prefix + str.charAt(i) = " + prefix + str.charAt(i));
				permutation(rem, prefix + str.charAt(i));
			}
		}
	}
	
}
	