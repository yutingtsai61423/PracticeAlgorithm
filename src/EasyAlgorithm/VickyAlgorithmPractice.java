package EasyAlgorithm;

import java.util.Arrays;

public class VickyAlgorithmPractice {
	//一般內部類別裡面要呼叫內部的成員時，要先在外部建立物件，透過此存取內部
	// 靜態內部類別與靜態函數一樣，此處不用透過外部類別建立物件存取內部成員
	public static void main(String[] args) {
		VickyAlgorithmPractice practice = new VickyAlgorithmPractice();
//		System.out.println(Arrays.toString(new SelectionSort().selectionSort()));
		
//		new Recursion().recursion(5);
//		System.out.println(new Recursion().factorial(5));
//		System.out.println(new DividedAndConquer().sumOfArrayByRecursion(new int[] {1, 2, 3, 4, 5, 6}));
		System.out.println(new DividedAndConquer().findMax(new int[] {1, 2, 3, 99, 5, 6 }));
	}
	
	//選擇排序法  1.剩餘找到最小 2.跟最左邊對調，最左邊剛更動完的不加入下一回合的搜尋
	private static class SelectionSort{
		private int[] selectionSort() {
			int[] arr = {5, 4, 3, 2, 1};
			for(int i = 0; i < arr.length; i++) { 
				//1.找到最小
				int tempMinIndex = findMin(arr, i);
				//2.跟最左邊對調
				int temp = 0;
				temp = arr[i];
				arr[i] = arr[tempMinIndex];
				arr[tempMinIndex]= temp; 
				
			}
			return arr;	
			
		}
		private int findMin(int[] arr, int i) { 
			int tempIndex = i;
			int tempMin = arr[i]; 
			for (int k = i+1; k  < arr.length; k++) {  
				if(arr[k] < tempMin) {
					tempIndex = k;
					tempMin = arr[k];
				}
			}
			return tempIndex;
		}
	}

	//遞迴 1.將問題分成兩步驟 且n要能越縮越小 2.找到basecase(終止的條件)
	private static class Recursion{
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
	
	//Divided and Conquer 將問題拆成子問題的方式。運用遞迴原理解決問題的方式 
	// 1. 試試看問題是否可以簡化成兩個跟n和n-1(或n/2 能把n數量縮減的都可以)有關的步驟 問題可重複依此原則化簡下去 直到出現baseCase
	// 2. 定義BaseCase(最小單位的問題)
	// * 若遞迴有用到陣列，通常baseCase會是空陣列 或陣列只有一個元素
	private static class DividedAndConquer{
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
		private int findMax(int[] arr) {
//			if (arr.length <= 2) {
//				return arr[1]>arr[0] ? arr[1] : arr[0];
//			} 
			if(arr.length <= 1) {
				return arr[0];
			}
			int maxFromLowerLayer = findMax(removeIndexZeroFromArray(arr));
			return arr[0]> maxFromLowerLayer ? arr[0]:maxFromLowerLayer;
		}
	}
	
}
