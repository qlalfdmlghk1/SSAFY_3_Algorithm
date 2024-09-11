package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SWEA_6808 {
static int N =9;
static int win=0;
static int lose =0;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	StringTokenizer st;
	
	int T = Integer.parseInt(br.readLine().trim());
	for(int t=1; t<=T; t++) {
		int[] my_card = new int[N];
		int[] opponent = new int[N];
		boolean[] all_card = new boolean[2*N];
		boolean[] visit = new boolean[N];
		win=0;
		lose=0;
		st=new StringTokenizer(br.readLine().trim());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			my_card[i] = num;
			all_card[num-1]=true;
		}
		int idx=0;
		for(int i=0; i<2*N; i++) {
			if(!all_card[i]) {
			opponent[idx++]=i+1;
			}
		}
		
		find(0,0,0,my_card,opponent,visit);
		sb.append("#"+t+" "+win+" "+lose+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void find(int score1, int score2, int depth, int[] my_card, int[] opponent, boolean[] visit) {
		if(depth == N) {
			if(score1 > score2) {
				win++;
			}
			else if(score1 < score2) {
				lose++;
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(visit[i]) {
				continue;
			}
				
			visit[i]=true;
			int num=my_card[i];
			if(num > opponent[depth]) {
				find(score1+num+opponent[depth], score2, depth+1, my_card,opponent,visit);
			}else if(num < opponent[depth]) {
				find(score1, score2+num+opponent[depth], depth+1, my_card,opponent,visit);
			}else {
				find(score1, score2, depth+1, my_card,opponent,visit);
			}
			visit[i]=false;
		}
	}
}