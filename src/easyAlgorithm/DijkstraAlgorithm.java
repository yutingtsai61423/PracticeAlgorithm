package easyAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class DijkstraAlgorithm {
	//題目圖形
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    /* 作法一
     * 1. 更新下一動節點成本　若有較低　就更新成本，並更新父節點位置，紀錄來時路。並把所在節點加到已拜訪過清單(也可有其他作法)。
     * 2. 選一個對起點來說目前成本最低的節點，移動到該點。
     * 3. 回到第一動
     * 
     * 註：此方式把圖論使用Map的方式記錄，把節點成本資料記在Map，把來時路記在Map
     * */
    
    /* 待驗證作法二
     * 1. 找出下一步可達的頂點，加入選單
     * 2. 評估下一步可達的頂點成本，若成本較原本低，就更新成本，且更新 所在位置 變成有更新成本的頂點
     */  
	public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        graph.put("fin", new HashMap<>());
        
     

	}

	
}
