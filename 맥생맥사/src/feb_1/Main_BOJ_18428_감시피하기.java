package feb_1;

import java.util.Scanner;

public class Main_BOJ_18428_감시피하기 {
	
	static int N;
	static char[][] map;
	static int ans;
	
	static int moveR[] = { -1, 1, 0, 0 }; 
	static int moveC[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				String str = sc.next();
				map[i][j]=str.charAt(0);
			}
		}
		
		dfs(0,-1,0);
		if(ans == 1) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void dfs(int r, int c, int cnt) {
		if(cnt == 3) {
			boolean yes = true;
			
			for (int i = 0; i<N; i++) {
				for (int j = 0; j <N; j++) {
					if(map[i][j] != 'T') continue;
					
					boolean student = findS(i,j);
					if(student == true) {
						yes=false;
						break;
					}
				}
				if(yes==false) break;
			}
			if(yes==true) ans =1;
			return;
			
		}
		
		for (int i = c+1; i < N; i++) {
			if(map[r][i] != 'X') continue;
			
			map[r][i] ='O';
			dfs(r,i,cnt+1);
			map[r][i]='X';
		}
		
		for (int i = r+1; i <N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 'X') continue;
				
				map[i][j]='O';
				dfs(i,j,cnt+1);
				map[i][j]='X';
			}
		}
	}

	private static boolean findS(int r, int c) {
		for(int i=0; i<4; i++) {
			int nextR = r;
			int nextC = c;
			while(true) {
				nextR += moveR[i];
				nextC += moveC[i];
				if(nextR<0 || nextR>=N || nextC<0 || nextC>=N)
					break;
				if(map[nextR][nextC] == 'O')
					break;
				
				if(map[nextR][nextC] == 'S')
					return true;
			
			}
		}
		
		return false;
	}

}
