import java.util.*;
public class BJ11653_소인수분해 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] isNotPrime = new boolean[N+1];
        if(N!=1){
            isNotPrime[0] = true;
            isNotPrime[1] = true;
            for (int i = 2; i <= N; i+=1) {
                if(!isNotPrime[i]){
                    for(int j=2; i*j <= N; j++){
                        isNotPrime[i*j] = true;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            List<Integer> Answers = new ArrayList<>();
            while(isNotPrime[N]){
                for (int i = 2; i <= N; i++) {
                    if(!isNotPrime[i]){
                        if(N%i==0){
                            N /= i;
                            Answers.add(i);
                            break;
                        }
                    }               
                }
            }
            Answers.add(N);
            Answers.sort(Comparator.comparingInt(o->o));
            for(int i:Answers){
                sb.append(i+"\n");
            }
            System.out.print(sb);
        }
        sc.close(); 
    }
}
