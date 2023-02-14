package easyAlgorithm;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(divideAndSort(new int[] {5, 4, 3, 2, 99, 1})));
	}
	
	public static int[] divideAndSort(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		return mergeAndSort(divideAndSort(leftPartArr(arr)), divideAndSort(rightPartArr(arr)));
	}
		
	public static int[] mergeAndSort(int[] left, int[] right) {
		System.out.printf("beforeMerge: left = %s, right = %s\n",Arrays.toString(left), Arrays.toString(right));
		int leftIndex = 0, rightIndex = 0;
		int[] mergeArr = new int[left.length + right.length];
		//因為切割奇數時，會讓右邊多一，所以右邊比較長
		for (int i = 0; i < mergeArr.length; i++) {
			if (leftIndex > left.length - 1) { //用完了
				mergeArr[i] = right[rightIndex++];
			} else if (rightIndex > right.length - 1) { //用完了
				mergeArr[i] = left[leftIndex++];
			} else if (left[leftIndex] <= right[rightIndex]) {
				mergeArr[i] = left[leftIndex++];
			} else {
				mergeArr[i] = right[rightIndex++];
			}
			System.out.println("mergeArr=" + Arrays.toString(mergeArr));
		}
		return mergeArr;
	}
	
	public static int[] leftPartArr(int[] arr) {
		int[] leftPartArr = new int[arr.length/2];
		for(int i = 0; i < leftPartArr.length; i ++) {
			leftPartArr[i] = arr[i];
		}
		System.out.println(Arrays.toString(leftPartArr));
		return leftPartArr;
	}
	
	public static int[] rightPartArr(int[] arr) {
		int leftPartLength = arr.length/2;
		int rightPartLength = arr.length/2;
		if (arr.length % 2 != 0) {
			rightPartLength += 1;
		}
		int[] rightPartArr = new int[rightPartLength];
		for (int i = 0; i < rightPartLength; i++) {
			rightPartArr[i] = arr[leftPartLength + i];
		}
		System.out.println(Arrays.toString(rightPartArr));
		return rightPartArr;
	}
}
