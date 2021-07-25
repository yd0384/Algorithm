import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10989_수정렬하기3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.valueOf(br.readLine());
		int[] result = new int[10001];
		for(int i=0;i<N;i++) {
			result[Integer.valueOf(br.readLine())]++;
		}
		for(int i=1;i<=10000;i++) {
			for(int j=0;j<result[i];j++) {
				bw.write(Integer.toString(i)+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
