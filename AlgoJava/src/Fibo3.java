package joon;

public class Fibo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int n=0,i=0,j=1,t=i;n<=1000000;t=j,j=i+j,i=t,n++){
			System.out.println(i%1000000);
		}
	}

}
