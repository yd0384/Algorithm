import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2805_나무자르기 {
	static List<Long> trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N, M;
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		trees = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		long low=0;
		long high=0;
		for(long i=0; i<N; i++){
			trees.add(Long.parseLong(st.nextToken()));
			high = Math.max(high, trees.get((int)i));
		}
		Collections.sort(trees, Collections.reverseOrder());
		long answer = 0;
		while(true){
			if(low > high){
				break;
			}
			long mid = (low + high) / 2;
			long sum = calc(mid);
			if(sum>M){
				answer = mid;
				low = mid + 1;
			}
			else if(sum==M){
				answer = mid;
				break;
			}
			else{
				high = mid - 1;
			}
			
		}
		System.out.println(answer);
	}
	static long calc(long value) {
		long sum = 0;
		for(long tree:trees){
			if(tree> value){
				sum += tree - value;
			}
		}
		return sum;		
	}
}
