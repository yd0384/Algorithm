

import java.util.Scanner;

public class Stick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int stick=64;
		int sum=0;
		int[] arr = new int[6];
		for(int i=0;i<6;i++){
			stick/=2;
			if(x==64){
				arr[i]=1;
				break;
			}
			arr[i]=x/stick;
			x%=stick;
		}
		for(int i:arr){
			sum+=i;
		}
		
		System.out.println(sum);
	}

}
