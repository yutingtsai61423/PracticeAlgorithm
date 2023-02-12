package easyAlgorithm;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

	public static void main(String[] args) {
		System.out.println(quickSortUseList(List.of(5, 4, 3, 21, 1, 99)));
	}

	public static List<Integer> quickSortUseList(List<Integer> list) {
		//判斷組的長度=1 return 這個數 若長度大於一 遞迴		
		if (list.size() <= 1) {
			return list;
		} else {
			//1.找pivot
			int pivot = list.get(0);
			//2.小的放一組 
			List<Integer> smaller =	list.stream()
										.skip(1)
										.filter(element -> element < pivot)
										.collect(Collectors.toList());
			//3.大的放一組
			List<Integer> bigger = list.stream()
										.skip(1)
										.filter(element -> element >= pivot)
										.collect(Collectors.toList());
			//4.拼起來
			return Stream.of(
							quickSortUseList(smaller).stream(),
							Stream.of(pivot),
							quickSortUseList(bigger).stream()
							)
						.flatMap(Function.identity())
						.collect(Collectors.toList());
		}
	}
}
