import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P9753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int[] k = new int[t];
		for(int i=0;i<t;i++){
			k[i]=sc.nextInt();
		}
		ArrayList<Integer> prime = new ArrayList<Integer>();
		prime.add(2);
		prime.add(3);
		for(int i=5;i<20000;i+=2){
			boolean chk=true;
			for(int j:prime){
				if(i%j==0){
					chk=false;
					break;
				}
			}
			if(chk){
				prime.add(i);
			}
		}
		ArrayList<Integer> products = new ArrayList<Integer>();
		for(int i:prime){
			for(int j:prime){
				if(i*j<=100001&&i*j>=0){
						if(!products.contains(i*j)&&i!=j){
							products.add(i*j);
						}
				}
			}
		}
		Collections.sort(products);
		for(int i:k){
			for(int j:products){
				if(j>=i){
					System.out.println(j);
					break;
				}
			}
		}
	}

}
