
import java.util.ArrayList;
import java.util.Scanner;

public class P2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] nine= new int[9];
		int sum=0;
		for(int i=0;i<9;i++){
			nine[i]=sc.nextInt();
			sum+=nine[i];
		}
		int fi=-1,si=-1;
		boolean flag=false;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(i!=j){
					if(sum==100+nine[i]+nine[j]){
						fi=i;
						si=j;
						flag=true;
						break;
					}
				}
			}
			if(flag){
				break;
			}
		}
		ArrayList<Integer> sorted=new ArrayList<Integer>();
		for(int i=0;i<9;i++){
			if(i!=fi && i!= si)
				sorted.add(nine[i]);
		}
		sorted.sort(null);
		for(int i:sorted)
			System.out.println(i);
	}

}
