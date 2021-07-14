

import java.util.Scanner;

public class P2490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] rs = new int[3][4];
		char ret=' ';
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				rs[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<3;i++){
			int sum=0;
			for(int j:rs[i]){
				sum+=j;
			}
			switch(sum){
			case 0:
				ret='D';
				break;
			case 1:
				ret='C';
				break;
			case 2:
				ret='B';
				break;
			case 3:
				ret='A';
				break;
			case 4:
				ret='E';
				break;
			default:
				break;
			}
			System.out.println(ret);
		}
		
	}

}
