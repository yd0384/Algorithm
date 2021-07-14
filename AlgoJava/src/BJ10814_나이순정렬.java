import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public class BJ10814_나이순정렬 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<ArrayList<String>> names = new ArrayList<ArrayList<String>>();
		for(int i=0;i<200;i++) {
			names.add(new ArrayList<String>());
		}
		int N = Integer.parseInt(br.readLine());
		for(int n=0;n<N;n++) {
			String[] s=br.readLine().split(" ");
			int age = Integer.parseInt(s[0]);
			names.get(age-1).add(s[1]);
		}
		for(int i=0;i<200;i++) {
			for(String name:names.get(i)) {
				bw.write(Integer.toString(i+1)+" "+name+"\n");
				bw.flush();
			}
		}
		bw.close();
	}

}
