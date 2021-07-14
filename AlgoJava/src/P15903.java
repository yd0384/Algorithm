
import java.util.Scanner;

public class P15903 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt(),point=0,i1=0,i2=0,sum=0;
		long min1=100000000001l,min2=100000000001l;
		int[] card=new int[n];
		for(int i=0;i<n;++i)card[i]=sc.nextInt();
		for(int i=0;i<m;++i){
			min1=100000000001l;
			min2=100000000001l;
			for(int j=0;j<n;++j){
				if(card[j]<min1){
					min1=card[j];
					i1=j;
				}
			}
			for(int j=0;j<n;++j){
				if(j!=i1&&card[j]<min2){
					min2=card[j];
					i2=j;
				}
			}
			sum=card[i1]+card[i2];
			card[i1]=card[i2]=sum;
		}
		for(int i:card)point+=i;
		System.out.println(point);
	}

}
