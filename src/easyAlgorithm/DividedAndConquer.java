package easyAlgorithm;

//Divided and Conquer 將問題拆成子問題的方式。運用遞迴原理解決問題的方式 
	// 1. 試試看問題是否可以簡化成兩個跟n和n-1(或n/2 能把n數量縮減的都可以)有關的步驟 問題可重複依此原則化簡下去 直到出現baseCase
	// 2. 定義BaseCase(最小單位的問題)
	// * 若遞迴有用到陣列，通常baseCase會是空陣列 或陣列只有一個元素
public class DividedAndConquer{
	
	public static void main(String[] args) {
		System.out.println(new DividedAndConquer().sumOfArrayByRecursion(new int[] {1, 2, 3, 4, 5, 6}));
		System.out.println(new DividedAndConquer().findMax(new int[] {1, 2, 3, 99, 5, 6 }));
	}
	
	//用遞迴寫出陣列數字加總
	private int sumOfArrayByRecursion(int[] arr) {
		if(arr.length ==0) {
			return 0;
		}
		return arr[0] + sumOfArrayByRecursion(removeIndexZeroFromArray(arr));
	}
	
	private int[] removeIndexZeroFromArray(int[] arr) {
		int[] newArray = new int[arr.length-1];
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = arr[i+1];
		}
		return newArray;
	}
	
	// 用遞迴找陣列最大數字
	int findMax(int[] arr) {
		if(arr.length <= 1) {
			return arr[0];
		}
		int maxFromLowerLayer = findMax(removeIndexZeroFromArray(arr));
		return arr[0]> maxFromLowerLayer ? arr[0]:maxFromLowerLayer;
	}
}