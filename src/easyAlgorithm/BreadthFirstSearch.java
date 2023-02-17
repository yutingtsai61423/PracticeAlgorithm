package easyAlgorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		Map<String, List<String>> friendRelationship = new HashMap<>();
		friendRelationship.put("Vicky", List.of("alice", "bob", "claire"));
		friendRelationship.put("bob", List.of("anuj", "peggy"));
		friendRelationship.put("alice", List.of("peggy"));
		friendRelationship.put("claire", List.of("thom", "jonny"));
		friendRelationship.put("anuj", Collections.emptyList());
		friendRelationship.put("peggy", Collections.emptyList());
		friendRelationship.put("thom", Collections.emptyList());
		friendRelationship.put("jonny", Collections.emptyList());
		
		System.out.println(search(friendRelationship, "Vicky", "peggy"));
		
	}
	
	public static boolean search(Map<String, List<String>> friendRelationship, String baseName, String targetName) {
		//找baseName的朋友，有沒有朋友認識targetName，將最近一層關係人加入待找清單
		Queue<String> toBeSearch = new ArrayDeque<>();
		List<String> hasBeenSearch = new ArrayList<>();
		toBeSearch.addAll(friendRelationship.get(baseName));
		while(!toBeSearch.isEmpty()) {
			String pollName = toBeSearch.poll();
			//找過的人不用再找，也不用將其朋友加入佇列，否則會形成 找A 把加入B，找B 把A加入的迴圈
			if (hasBeenSearch.contains(pollName)) {
				continue;
			}
			//如果baseName的朋友都沒有此人，就把baseName的朋友的朋友加入待查清單最後面(視為第二層關係人)
			if(pollName != null && pollName.equals(targetName)) {
				return true;
			} else {
				toBeSearch.addAll(friendRelationship.get(pollName));
				hasBeenSearch.add(pollName);
			}
		}
		
		return false;
		
	}
}
