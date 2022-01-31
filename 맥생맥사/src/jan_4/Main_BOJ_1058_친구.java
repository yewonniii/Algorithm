package jan_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_1058_친구 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		int[][] isCheck= new int[N][N]; //이미 친구로 등록했는지 체크 
		int [] ans = new int[N]; //각 노드의 친구 수 저장 
		
		String str;
		
		for (int i = 0; i < N; i++) {
			str=br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]=='Y') { //자기 자신과 친구라면 
					if(isCheck[i][j]==0) {
						ans[i]++; //친구로 등록 안되어있으면 친구 수 +1 하고, 친구로 등록 
						isCheck[i][j]=1;
					}
					
					for (int k = 0; k < N; k++) { //친구의 친구 구하기 
						if(arr[j][k]=='Y' && isCheck[i][k]==0 && i != k) {
							//친구의 친구가 존재하고, 아직 친구로 등록하지 않았고, 친구의 친구가 나 자신이 아니라면 
							ans[i]++;
							isCheck[i][k]=1;
						}
					}
				}
			}
		}
		
		Arrays.sort(ans);
		System.out.println(ans[N-1]);

	}

}
