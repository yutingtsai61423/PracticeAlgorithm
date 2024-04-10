package cracking189.arrayAndString;

public class IsUniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUniqueChar("asdfghjkl"));

	}
	//實作演算法判斷字串中的字源都不重複
	public static boolean isUniqueChar(String str) {
		//採用ASCII字元表，一共128個字元
		//若字串長度大於128，代表一定有字元重複
		if (str.length() > 128) {
			return false;
		}
		
		boolean[] aSCIICharSet = new boolean[128]; //預設值為false
		for (int i = 0; i < str.length(); i++) {
			if (aSCIICharSet[str.charAt(i)] == false) {
				//若字元不存在，把遇到的改為true
				aSCIICharSet[str.charAt(i)] = true;
			} else {
				//如果字元已經有存在，就是有重複字元
				return false;
			}
		}
		return true;
	}
	
}
