import java.util.Scanner;

public class BJ1436_영화감독숌 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long i = 0;
		long j = 0;
		int cnt=0;
		long n=sc.nextLong();
		while(i<n) {
			j++;
			cnt=0;
			for(char c:Long.toString(j).toCharArray()) {
				if(c=='6')
					cnt++;
				else
					cnt=0;
				if(cnt>=3) {
					i++;
					break;
				}
			}
				
		}
		System.out.println(j);
		sc.close();
	}

}
