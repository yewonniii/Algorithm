package feb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_16172_나는친구가적다 {

	public static int pi[];
	public static String S, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().replaceAll("[0-9]", "");
		K = br.readLine();
		
		pi= new int[K.length()];
		getPi();
		KMP();

	}

	private static void getPi() {
		int j =0;
		for (int i = 1; i < K.length(); i++) {
			while(j>0 && K.charAt(i) != K.charAt(j)) {
				j=pi[j-1];
			}
			if(K.charAt(i) == K.charAt(j)) {
				pi[i]= ++j;
			}
		}
		
	}
	
	private static void KMP() {
		int j=0;
		int result = 0;
		
		for (int i = 0; i < S.length(); i++) {
			while(j>0 && S.charAt(i) != K.charAt(j)) {
				j = pi[j-1];
			}
			if(S.charAt(i) == K.charAt(j)) {
				if(j== K.length()-1) {
					result=1;
					break;
				}
				else ++j;
			}
		}
		System.out.println(result);
		
	}

}
