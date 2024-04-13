package cracking189.arrayAndString;


public class URLify {

	public static void main(String[] args) {

		replaceSpaces2(new char[] {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ', ' ', ' '}, 13);
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
	public static void replaceSpaces2(char[] str, int trueLength) {
		//假設給的長度char[]後面空白超長，先找到終點在哪裡
		int strNewLen = trueLength;
		int ii = 0;
		for(char chr : str) {
			if(ii >= trueLength) break;
			//如果是空白，總長要多加2
			if (chr == ' ') {
				strNewLen += 2;
			}
			ii++;
		}
		System.out.println(strNewLen);
		
		int cursor = strNewLen-1;
		//再把字元由尾端一個一個往最後面搬
		for (int i = trueLength -1; i >= 0; i--) {
			if (str[i] == ' ') {
				//先放0 再放2 再放%
				str[cursor] = '0';
				str[cursor-1] = '2';
				str[cursor-2] = '%';
				cursor -= 3;
			} else {
				str[cursor] = str[i];
				cursor --;
			}
		}

		for(char c : str) {
			System.out.print(c);
		}
	}
	
}
