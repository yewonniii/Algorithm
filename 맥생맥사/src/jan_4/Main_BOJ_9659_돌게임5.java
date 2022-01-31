package jan_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9659_돌게임5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		if(N%2==1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
		

	}

}
