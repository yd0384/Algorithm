package joon;

import java.util.ArrayList;
import java.util.Scanner;

public class SmallS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc =new Scanner(System.in);
			int n=sc.nextInt();
			int[] a=new int[n];
			ArrayList<Integer> b = new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++){
				b.add(sc.nextInt());
			}
			int tmp=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n-i-1;j++){
					if(a[j]>a[j+1]){
						tmp=a[j];
						a[j]=a[j+1];
						a[j+1]=tmp;
					}
				}
			}
			int max=0;
			int S=0;
			int k=-1;
			for(int i=0;i<b.size();i++,S+=a[k]*max,b.remove(tmp),max=0){
				if(tmp<b.get(i)){
					max=b.get(i);
					tmp=i;
				}
				k++;
			}
			System.out.println(S);
	}

}
