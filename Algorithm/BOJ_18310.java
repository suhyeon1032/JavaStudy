package array;

import java.io.*;
import java.util.*;

public class BOJ_18310 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int homeNum = Integer.parseInt(br.readLine());
	    int []distance = new int[homeNum];
	    int []homes = new int[homeNum];
	    int i=0;

	    StringTokenizer st = new StringTokenizer(br.readLine());

	    while (st.hasMoreTokens()){
	        homes[i]=Integer.parseInt(st.nextToken());
	        i++;
	    }

	    Arrays.sort(homes);

	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    bw.write(Integer.toString(homes[homeNum/2-1]));
	    bw.flush();
	    bw.close();

	}

}
