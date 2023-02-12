package easyAlgorithm;

import java.util.Arrays;

//選擇排序法  1.剩餘找到最小 2.跟最左邊對調，最左邊剛更動完的不加入下一回合的搜尋
public class SelectionSort{
    public static void main(String[] args) {
		System.out.println(Arrays.toString(selectionSort()));
    }
	private static int[] selectionSort() {
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
	private static int findMin(int[] arr, int i) { 
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