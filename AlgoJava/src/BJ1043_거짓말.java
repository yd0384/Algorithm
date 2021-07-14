import java.util.ArrayList;
import java.util.Scanner;

public class BJ1043_거짓말 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] nm = sc.nextLine().split(" ");
		int N=Integer.parseInt(nm[0]), M=Integer.parseInt(nm[1]);
		String s = sc.nextLine();
		int K,l;
		String[] ss=s.split(" ");
		K=Integer.parseInt(ss[0]);
		ArrayList<Integer> Ks = new ArrayList<Integer>();
		for(int k=0;k<K;k++) {
			Ks.add(Integer.parseInt(ss[k+1]));
		}
		
		
		
		ArrayList<Integer>[] party = new ArrayList[M];
		for(int m=0;m<M;m++) {
			party[m]=new ArrayList<Integer>();
			s=sc.nextLine();
			if(s.equals("0")) {
				l=0;
			}
			else {
				ss=s.split(" ");
				l=Integer.parseInt(ss[0]);
				for(int i=0;i<l;i++) {
					party[m].add(Integer.parseInt(ss[i+1]));
				}
				
			}
			
		}
		
		boolean[] lied = new boolean[M];
		for(int i=0;i<M;i++) {
			lied[i]=true;
		}
		int after;
		while(true) {
			int before=Ks.size();
			for(int i=0;i<M;i++) {
				for(int j=0;j<before;j++) {
					if(party[i].contains(Ks.get(j))) {
						lied[i]=false;
						for(int x:party[i]) {
							if(!Ks.contains(x)) {
								Ks.add(x);
							}
						}
					}
				}
				
			}
			after=Ks.size();
			if(after==before)
				break;
		}
		int count=0;
		for(int i=0;i<M;i++) {
			if(lied[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
