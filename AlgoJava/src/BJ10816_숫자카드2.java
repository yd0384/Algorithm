import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] counter = new int[20000001];
		int N = Integer.parseInt(br.readLine());
		String[] nums = br.readLine().split(" ");
		for(int n=0;n<N;n++) {
			counter[Integer.parseInt(nums[n])+10000000]+=1;
		}
		int M = Integer.parseInt(br.readLine());
		String[] mums = br.readLine().split(" ");
		for(int m=0;m<M-1;m++) {
			bw.write(Integer.toString(counter[Integer.parseInt(mums[m])+10000000])+" ");
		}
		bw.write(Integer.toString(counter[Integer.parseInt(mums[M-1])+10000000])+"\n");
		bw.flush();
		bw.close();
	}

}
