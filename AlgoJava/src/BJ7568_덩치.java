import java.util.ArrayList;
import java.util.Scanner;

public class BJ7568_덩치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.valueOf(sc.nextLine());
		ArrayList<Integer>[] xy = new ArrayList[2];
		xy[0] = new ArrayList<Integer>();
		xy[1] = new ArrayList<Integer>();
		for(int n=0;n<N;n++) {
			String[] s = sc.nextLine().split(" ");
			xy[0].add(Integer.valueOf(s[0]));
			xy[1].add(Integer.valueOf(s[1]));
		}
		int[] results = new int[N];
		for(int i=0;i<N;i++) {
			int result=1;
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(xy[0].get(i) < xy[0].get(j) && xy[1].get(i) < xy[1].get(j)) {
					result++;
				}
			}
			results[i]=result;
		}
		String r = "";
		for(int i:results) {
			r+=Integer.valueOf(i)+" ";
		}
		System.out.println(r);
	}

}
