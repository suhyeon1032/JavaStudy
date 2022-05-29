package ssafy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2784 {

	public static void main(String args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[6];
		for(int i=0; i<6; i++) {
			arr[i] = br.readLine();
		}
		for(int i=0; i<6; i++) {
			System.out.println(arr[i]);
		}
	}

}
