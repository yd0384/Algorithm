import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ11651_좌표정렬하기2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.valueOf(br.readLine());
		ArrayList<Integer>[] point = new ArrayList[200001];
		for(int i=0;i<200001;i++) {
			point[i] = new ArrayList<Integer>();
		}
		for(int n=0;n<N;n++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.valueOf(s[0]);
			int y = Integer.valueOf(s[1])+100000;
			int l=point[y].size();
			if(point[y].isEmpty()) {
				point[y].add(x);
				continue;
			}
			for(int j=0;j<l;j++) {
				if(x<point[y].get(j)) {
					point[y].add(j, x);
					break;
				}
			}
			if(l==point[y].size())
				point[y].add(x);
		}
		for(int i=0;i<200001;i++) {
			for(int x:point[i]) {
				bw.append(Integer.toString(x)+" "+Integer.toString(i-100000)+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
