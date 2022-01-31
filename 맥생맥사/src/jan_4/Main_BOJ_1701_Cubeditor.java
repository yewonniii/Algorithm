package jan_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1701_Cubeditor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans =0;
		
		for (int i = 0; i < str.length(); i++) {
			String pattern = str.substring(i,str.length());
			ans = Math.max(ans, getMaxLen(pattern));
		}
		
		System.out.println(ans);

	}

	private static int getMaxLen(String str) {
		int j=0;
		int max=0;
		
		int pi[] = new int[str.length()];
		
		for (int i = 1; i < str.length(); i++) {
			while(j >0 && str.charAt(i) !=str.charAt(j) ) {
				j=pi[j-1];
			}
			
			if(str.charAt(i) == str.charAt(j)) {
				pi[i]= ++j;
				max=Math.max(max, pi[i]);
			}
		}
		return max;
	}

}
