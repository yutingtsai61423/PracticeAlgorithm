package easyAlgorithm;

//遞迴 1.將問題分成兩步驟 且n要能越縮越小 2.找到basecase(終止的條件)
public class Recursion{
	public static void main(String[] args) {
		new Recursion().recursion(5);
		System.out.println(new Recursion().factorial(5));
	}
	// 倒數計時練習
	private void recursion(int num) {
		System.out.println(num--);
		if(num <=0) {
			return;
		} else {
			recursion(num);
		}
	}
	
	//試用遞迴寫出N!
	private int factorial(int num) {
		if(num == 1) {
			return 1;
		}
		return num * factorial(num-1);
	}
}