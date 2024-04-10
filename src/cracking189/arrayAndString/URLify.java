package cracking189.arrayAndString;

public class URLify {

	public static void main(String[] args) {

		
	}


	//使用stringBuilder的做法
	public static String replaceSpaces(char[] str, int trueLength) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < trueLength; i++) {
			if (" ".equals(String.valueOf((char)str[i]))) {
				builder.append("%20");
			} else {
				builder.append(str[i]);
			}
		}
		return builder.toString();
	}
	
	/******************************************/
	//只使用題目給的str提供的空間，位移和插入字元，不多new其他字串
	public static String replaceSpaces2(char[] str, int trueLength) {
		
		return "";
	}
	
}
