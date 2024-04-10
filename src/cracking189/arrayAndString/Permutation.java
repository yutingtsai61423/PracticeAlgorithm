package cracking189.arrayAndString;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		System.out.println(permutation("abfff", "ffbgf"));
		System.out.println(permutation2("abfff", "ffabf"));
	}
	
	//方法一
	//判斷兩字串是否為變位字
	static boolean permutation(String s, String t) {
		//兩字串長度必須先相等
		if(s.length() != t.length()) {
			return false;
		}
		
		//排序後會長一樣
		return sortWords(s).equals(sortWords(t));
	}

	public static String sortWords(String str) {
		//把字串排序
		char[] strCharArr = str.toCharArray();
		Arrays.sort(strCharArr);
		return new String(strCharArr);
	}
	
	/********************************************/
	//方法二
	//把字元都+1登記之後，另一個字串的字元-1對比，如果全都是0表示兩者一樣
	public static boolean permutation2(String s, String t) {
		//使用ASCII字元表 128個值
		int[] ascii = new int[128];
		for (int i = 0; i < s.length(); i++) {
			ascii[s.charAt(i)]++ ;//該字元代表的ASCIICODE +1
		}
		
		for (int i = 0; i < t.length(); i++) {
			ascii[t.charAt(i)]-- ;//該字元代表的ASCIICODE -1
		}
		
		return Arrays.stream(ascii).allMatch(e -> e == 0); //若全都是0 就是變位字 
		
	}
	
	

}
