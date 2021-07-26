import java.util.Scanner;

public class BJ18111_마인크래프트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int B = Integer.parseInt(s[2]);
		int[][] board = new int[N][M];
		for(int i=0;i<N;i++) {
			s = sc.nextLine().split(" ");
			for(int j=0;j<M;j++) {
				board[i][j]=Integer.parseInt(s[j]);
			}
		}
		int time=Integer.MAX_VALUE, h=0, tmp=0;
		int up=0, down=0;
		for(int i=0;i<257;i++) {
			up=0;
			down=0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(board[j][k]-i>=0) {
						down+=board[j][k]-i;
					}
					else {
						up+=i-board[j][k];
					}
				}
			}
			if(up>down+B) {
				break;
			}
			tmp=2*down + 1*up;
			if(tmp<=time) {
				time=tmp;
				h=i;
			}
		}
		System.out.println(Integer.toString(time)+" "+Integer.toString(h));
		sc.close();
	}

}
