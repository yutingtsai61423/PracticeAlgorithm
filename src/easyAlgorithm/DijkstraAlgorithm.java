package easyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraAlgorithm {
	//題目圖形
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static List<String> hasBeenProcess = new ArrayList<>();
    
    /* 作法一
     * 1. 更新下一動節點成本　若有較低　就更新成本，並更新父節點位置，紀錄來時路。並把所在節點加到已拜訪過清單(也可有其他作法)。
     * 2. 選一個對起點來說目前成本最低的節點，移動到該點。
     * 3. 回到第一動
     * 
     * 需要記的東西：父節點、最終更新完成本、哪些拜訪過了、圖論本身
     * 
     * 註：此方式把圖論使用Map的方式記錄，把節點成本資料記在Map，把來時路記在Map
     * */
    

	public static void main(String[] args) {
		//製圖
		graph.put("start", new HashMap<String, Double>());
		graph.get("start").put("A", 6.0);
		graph.get("start").put("B", 2.0);
		
		graph.put("A", new HashMap<>());
		graph.get("A").put("Fin", 1.0);
		
		graph.put("B", new HashMap<>());
		graph.get("B").put("A", 3.0);
		graph.get("B").put("Fin", 5.0);
		
		Map<String, Double> costFromVertex = new HashMap<>();
		costFromVertex.put("A", 6.0);
		costFromVertex.put( "B",2.0);
		costFromVertex.put("Fin",Double.POSITIVE_INFINITY );
		
		Map<String, String> parent = new HashMap<>();
		parent.put("A", "start");
		parent.put("B", "start");
		parent.put("Fin", null);
		
		while (hasBeenProcess.size() <= graph.size()) {
			evaluateCost(parent, costFromVertex, findLowestCostNode(costFromVertex));
		}
		
		System.out.println("cost result" + costFromVertex);
	}
		//找目前成本最低 
	public static String findLowestCostNode(Map<String,Double > costFromVertex) {
		Double lowestCost = Double.POSITIVE_INFINITY;
		String lowestCostNodeName = null;
		for (Map.Entry<String,Double> costEntry : costFromVertex.entrySet()) {
			if (hasBeenProcess.contains(costEntry.getKey())) {
				continue;
			}
			if (costEntry.getValue() < lowestCost) {
				lowestCost = costEntry.getValue();
				lowestCostNodeName = costEntry.getKey();
			}
		}
		System.out.println("lowestCostNodeName"+ lowestCostNodeName);
		return lowestCostNodeName;
	}

	public static void evaluateCost(Map<String, String> parent, Map<String, Double> costFromVertex, String selectedNode) {
		//找下一動節點，更新成本
		//本點權重
		Double thisNodeWeight = costFromVertex.get(selectedNode);
		//找我的下一棒有誰
		Map<String, Double> nextSteps = graph.get(selectedNode);
		//比較成本
		if(nextSteps == null) {
			hasBeenProcess.add(selectedNode);
			return;
		}
		for (Map.Entry<String, Double> entry: nextSteps.entrySet()) {
			Double newWeight = entry.getValue() + thisNodeWeight;
			if(newWeight < costFromVertex.get(entry.getKey())) {
				//更新成本 而且更新來時路-父節點
				costFromVertex.put(entry.getKey(), newWeight);
				parent.put(entry.getKey(), selectedNode);
			}
		}
		hasBeenProcess.add(selectedNode);
	}
	
}
