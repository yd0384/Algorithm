import java.io.*;
import java.util.StringTokenizer;
public class BJ1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[100001];
        int i=0;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int sum = arr[0];
        int low = 0; 
        int high = 0;
        int answer = 0;
        while(true){
            if(sum>=S){
                if(answer==0){
                    answer = high-low + 1;
                }
                else{
                    answer = Math.min(answer, high- low + 1);
                }
                sum -= arr[low++];
            }
            else{
                
                sum += arr[++high];
                if(high==N){
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
//슬라이딩 윈도우
//합이 S보다 크거나 같으면 정답 조건에 들어간다.
//answer가 0이면 부분의 길이로 대체하고, 0이아닌 값이 있으면 min으로 더 작은값으로 대체한다.
//합이 S보다 작으면
//sum을 확장한다
//high가 n에 도달하면 나간다.
