package joon;

import java.util.Scanner;

public class P2448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int n=sc.nextInt();
		int k=n/3;
		int x=2*n-1;
		for(int i=0;i<n;i++){
			for(int j=0;j<x;j++){
				sb.append(' ');
			}
		}
		sb.replace(x/2,x/2+1,"*");
		for(int i=1;i<n;i++){
			if(i%3==1){
				for(int j=0;j<x;j++){
					if(sb.charAt((i-1)*x+j)=='*'){
						sb.replace(i*x+j-1,i*x+j,"*");
						sb.replace(i*x+j+1,i*x+j+2,"*");
					}
				}
				
			}
			else if (i%3==2){
				for(int j=0;j<x;j++){
					if(sb.charAt((i-1)*x+j)=='*' && sb.charAt((i-1)*x+j+2)=='*'){
						sb.replace(i*x+j-1,i*x+j,"*");
						sb.replace(i*x+j,i*x+j+1,"*");
						sb.replace(i*x+j+1,i*x+j+2,"*");
						sb.replace(i*x+j+2,i*x+j+3,"*");
						sb.replace(i*x+j+3,i*x+j+4,"*");
					}
				}
			}
			else if (i%3==0){
				for(int j=0;j<x;j++){
					if(sb.charAt((i-1)*x+j)=='*'&&sb.charAt((i-1)*x+j+1)=='*'&&sb.charAt((i-1)*x+j+2)=='*'&&sb.charAt((i-1)*x+j+3)=='*'&&sb.charAt((i-1)*x+j+4)=='*'){
						if(sb.charAt((i-1)*x+j-2)!='*'){
							sb.replace(i*x+j-1,i*x+j,"*");
						}
						if(sb.charAt((i-1)*x+j+6)!='*'){
							sb.replace(i*x+j+5,i*x+j+6,"*");
						}
					}
				}
			}
		}
			/*
			else if(i%3==2){
				strs[i]=strs[i-1].replace(" * * ","*****");
			}
			else if(i%3==0){
				char[] before = strs[i-1].toCharArray();
				charr=strs[i].toCharArray();
				for(int j=0;j<k*5+(k-1);j++){
					if(before[j]=='*' && before[j+1]=='*' && before[j+2]=='*' && before[j+3]=='*' && before[j+4]=='*'){
						if(before[j-2]!='*'){
							charr[j-1]='*';
						}
						if(before[j+6]!='*'){
							charr[j+5]='*';
						}
					}
				}
				strs[i]=new String(charr);
			}
		}
		*/
		for(int i1=0;i1<n;i1++){
			for(int j=0;j<x;j++){
				System.out.print(sb.charAt(i1*x+j));
			}
			System.out.println();
		}
			
	}

}
