
import java.util.ArrayList;
import java.util.Scanner;

public class numtri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++){
			ArrayList<Integer> num= new ArrayList<Integer>();
			for(int j=0;j<=i;j++){
				num.add(sc.nextInt());
			}
			nums.add(num);
		}
		for(int i=n-1;i>0;i--){
			for(int j=i;j>0;j--){
				nums.get(i-1).set(j-1, Math.max(nums.get(i).get(j), nums.get(i).get(j-1))+nums.get(i-1).get(j-1));
			}
		}
		System.out.println(nums.get(0).get(0));
	}

}
