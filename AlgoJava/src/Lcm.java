
import java.util.ArrayList;
import java.util.Scanner;

public class Lcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=0;
		ArrayList<Integer> Lcm=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			m=a*b;
			ArrayList<Integer> d=new ArrayList<Integer>();
			for(int j=a;j<=m;j+=a){
				if(j%a==0){
					d.add(j);
				}
			}
			for(int x:d){
				if(x%b==0){
					Lcm.add(x);
					break;
				}
			}
			
		}
		for(int x:Lcm){
			System.out.println(x);
		}
	}

}
