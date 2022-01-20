import java.util.*;
import java.io.*;
public class BJ14476_최대공약수하나빼기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int[] LR = new int[N];
        int[] RL = new int[N];
        LR[0] = arr.get(0);
        for(int i=1;i<N;i++){
            LR[i] = GCD(LR[i-1], arr.get(i));
        }
        RL[N-1] = arr.get(N-1);
        for(int i=N-2; i>=0; i--){
            RL[i] = GCD(RL[i+1], arr.get(i));
        }
        int answer = -1;
        int answerK = 0;
        for(int i=0;i<N;i++){
            int K = arr.get(i);
            if(i==0){
                if(K%RL[1] != 0){
                    if(answer < K%RL[1]){
                        answer = RL[1];
                        answerK = K;
                    }
                }
            }
            else if(i==N-1){
                if(K%LR[N-2] != 0){
                    if(answer < K%LR[N-2]){
                        answer = LR[N-2];
                        answerK = K;
                    }
                }
            }
            else{
                int gcd = GCD(RL[i+1], LR[i-1]);
                if(K%gcd!=0){
                    if(gcd>answer){
                        answer = gcd;
                        answerK = K;
                    }
                }
            }
        }
        if(answer!=-1){
            System.out.println(answer + " " + answerK);
        }
        else{
            System.out.println(answer);
        }
    }
    public static int GCD(int a, int b){
        if(b==0){
            return a;
        }
        int r = a%b;
        return GCD(b, r);
    }
}
//누적 GCD
//a, b의 대소관계는 한번 함수를 돌면 자동으로 스왑되므로 신경쓰지 않아도 된다.
