

import java.util.Scanner;

public class sort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		boolean arr[] = new boolean[2000001];
		for(int i=0;i<n;i++){
			arr[sc.nextInt()+1000000]=true;
		}
		for(int i=0;i<2000001;i++){
			if(arr[i]){
				System.out.println(i-1000000);
			}
		}
	}

}
