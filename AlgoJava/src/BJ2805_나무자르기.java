import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] trees = new int[N];
		int maxh=0;
		s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			trees[i]=Integer.parseInt(s[i]);
			if(trees[i]>maxh)
				maxh=trees[i];
		}
		int left=1, mid=0, right=maxh, amount=0, result=0;
		while(left<=right) {
			amount=0;
			mid = (left+right)/2;
			for(int t:trees) {
				if(t-mid>0) {
					amount+=t-mid;
				}
			}
			if(amount>=M) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
			
		}
		bw.write(Integer.toString(right));
		bw.flush();
		bw.close();
	}

}
