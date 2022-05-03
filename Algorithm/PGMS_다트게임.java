package week15;

public class PGMS_다트게임 {
	public int solution(String dartResult) {
        int answer = 0;
        int arr[] = new int[3];
        int idx = 0, intCnt = 0;
        
        for(int i=0; i<dartResult.length(); i++) {
        	char c = dartResult.charAt(i);
        	int dartI = Character.getNumericValue(c);
        	
        	if(dartI >= 0 && dartI <=10) {
        		if(dartI == 1) {
        			if(Character.getNumericValue(dartResult.charAt(i+1)) == 0) {
	        			dartI = 10;
	        			i++;
	        		}
        		}
        		arr[idx] = dartI;
            	intCnt++;
        	} else {
        		switch (c) {
				case 'S': //Single
					arr[idx] = (int) Math.pow(arr[idx], 1);
					idx++;
					break;
				case 'D': // Double
					arr[idx] = (int) Math.pow(arr[idx], 2);
					idx++;
					break;
				case 'T': // Triple
					arr[idx] = (int) Math.pow(arr[idx], 3);
					idx++;
					break;
				default:
					break;
				}
        	}
        	
        }
        return answer;
    }
}
