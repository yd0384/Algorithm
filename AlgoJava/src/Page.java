

import java.util.Scanner;

public class Page {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int index[]=new int[10];
		for(int i=0;i<10;i++){
			index[i]=0;
		}
		for(int i=1;i<=n;i++){
			String s=Integer.toString(i);
			int l=s.length();
			for(int j=0;j<l;j++){
				switch(s.charAt(j)){
				case '0':
					index[0]++;
					break;
				case '1':
					index[1]++;
					break;
				case '2':
					index[2]++;
					break;
				case '3':
					index[3]++;
					break;
				case '4':
					index[4]++;
					break;
				case '5':
					index[5]++;
					break;
				case '6':
					index[6]++;
					break;
				case '7':
					index[7]++;
					break;
				case '8':
					index[8]++;
					break;
				case '9':
					index[9]++;
					break;	
				}
			}
		}
		for(int i=0;i<10;i++){
			System.out.print(index[i]+" ");
		}
	}

}
