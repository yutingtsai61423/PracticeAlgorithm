package easyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DijkstraAlogorithmVersion2 {
    /*
     * 1. 找出下一步可達的頂點，加入選單
     * 2. 評估下一步可達的頂點成本，若成本較原本低，就更新成本，且更新 所在位置 變成有更新成本的頂點
     */  
	private static Map<String, List<Node>> graph = new HashMap<>(); //圖論
	private static PriorityQueue<Node> pq = new PriorityQueue<>();//待評估選單
	private static List<Node> weight = new ArrayList<>();
	
	public static void main(String[] args) {
		//先設定權重初始值
		weight.add(new Node().setThisNodeName("A").setParentNode(null).setCost(0));
		weight.add(new Node().setThisNodeName("B").setParentNode("A").setCost(Integer.MAX_VALUE));
		weight.add(new Node().setThisNodeName("C").setParentNode("A").setCost(Integer.MAX_VALUE));
		weight.add(new Node().setThisNodeName("D").setParentNode("A").setCost(Integer.MAX_VALUE));
		weight.add(new Node().setThisNodeName("E").setParentNode("A").setCost(Integer.MAX_VALUE));
		
		//準備圖形
		graph.put("A", List.of(new Node().setThisNodeName("B").setCost(9), 
								new Node().setThisNodeName("C").setCost(6),
								new Node().setThisNodeName("D").setCost(5),
								new Node().setThisNodeName("E").setCost(3)));
		graph.put("B", List.of(new Node().setThisNodeName("C").setCost(2)));
		graph.put("C", List.of(new Node().setThisNodeName("D").setCost(4)));
		graph.put("D", List.of());
		graph.put("E", List.of());
		
		
		//search this point and put brothers in pq
//		pq.offer(null);
		
		//find cheapest one
		
		//evluate next nodes
		
		//assessment and renew


	}
		//search this point and put brothers in pq
	public static void searchAddPQ(Node nodeToBeSearch) {
		
		

	}
	
	private static class Node{ //內部類別加上static->讓使用此類別的人不需要new出外部類別的實體來使用此類別
						//new出來會在記憶體畫出空間，所以指向不同個實體
						//內部類別加上private 只能外部類別使用 加上public 整個project可以共用 沒加預設同package使用
		String thisNodeName;
		String parentNode;
		String nextNode;
		int cost;

		public String getThisNodeName() {
			return thisNodeName;
		}

		public Node setThisNodeName(String thisNodeName) {
			this.thisNodeName = thisNodeName;
			return this;
		}

		public String getParentNode() {
			return parentNode;
		}

		public Node setParentNode(String parentNode) {
			this.parentNode = parentNode;
			return this;
		}

		public int getCost() {
			return cost;
		}

		public Node setCost(int cost) {
			this.cost = cost;
			return this;
		}

		public String getNextNode() {
			return nextNode;
		}

		public Node setNextNode(String nextNode) {
			this.nextNode = nextNode;
			return this;
		}


		
		
	}

}

