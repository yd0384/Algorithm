import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ1654_랜선자르기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		int K = Integer.parseInt(s[0]);
		long N = Long.parseLong(s[1]);
		long[] lines = new long[K];
		for(int k=0;k<K;k++) {
			lines[k] = Long.parseLong(br.readLine());
		}
		long left = 1;
		long right = Integer.MAX_VALUE;
		long mid=Math.round((left+right)/2);
		long makable=0;
		while(left+1<right) {
			mid=Math.round((left+right)/2);
			makable=0;
			for(long k:lines) {
				makable+=k/mid;
			}
			if(makable>=N) {
				left=mid;
			}
			else if(makable<N) {
				right=mid;
			}
		}
		
		bw.write(Long.toString(left)+"\n");
		bw.flush();
		bw.close();
	}

}
