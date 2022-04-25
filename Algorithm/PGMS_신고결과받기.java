package week13;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PGMS_신고결과받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> mail = new HashMap<>();
        
        for (String user : id_list) {
			map.put(user, new LinkedList<>()); // key:유저 value:신고한 사람들
			mail.put(user, 0); 
		}
        
        for(String a: report) {
        	String[] id=a.split(" ");
        	String fromId=id[0], toId=id[1];
        	
        }
        return answer;
    }
}
