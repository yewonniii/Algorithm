package jan_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_8911_거북이 {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int ans=0;
		
		for (int tc = 1; tc <= T; tc++) {
			//x,y좌표값의 최대최소 
			int minX =0, minY =0, maxX =0, maxY =0;
			
			//거북이의 x,y의 현재위치 
			int nowX =0, nowY =0;
			
			//거북이의 방향설정 (북:0, 동:1, 남:2, 서:3)
			int dir=0;
			
			String str = br.readLine();
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(c=='F') { //한 눈금 앞으로 
					nowX = nowX+dx[dir];
					nowY = nowY+dy[dir];
				}else if(c=='B'){//한 눈금 뒤로 
					nowX = nowX-dx[dir];
					nowY = nowY-dy[dir];
				}else if(c=='L') { //왼쪽으로 90도 회전 
					if(dir==0) dir=3;
					else dir--; 
				}else if(c=='R') { //오른쪽으로 90도 회전 
					if(dir==3) dir=0;
					else dir++;
				}
				
				minX=Math.min(minX, nowX);
				minY=Math.min(minY, nowY);
				maxX=Math.max(maxX, nowX);
				maxY=Math.max(maxY, nowY);
				
			}
			ans =((Math.abs(minX)+Math.abs(maxX))*(Math.abs(minY)+Math.abs(maxY)));
			System.out.println(ans);
		}
		

	}

}