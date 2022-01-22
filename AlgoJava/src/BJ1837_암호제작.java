import java.util.*;
public class BJ1837_암호제작 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        String P = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[K];
        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<K; i++){
            if(!isNotPrime[i]){
                primes.add(i);
                for(int j=2; i*j<K; j++){
                    isNotPrime[i*j]=true;
                }
            }
        }
        int pLen = P.length();
        if(pLen < Integer.toString(K).length()){
            int intP = Integer.parseInt(P);
            boolean found = false;
            for(int i:primes){
                if(intP%i==0){
                    found = true;
                    System.out.println("BAD "+i);
                    break;
                }
            }
            if(!found){
                System.out.println("GOOD");
            }
        }
        else{
            boolean found = false;
            for(int i:primes){
                int r = 0;
                for(int j=0;j<pLen;j++){
                    r = (r*10+P.charAt(j)-'0') % i;
                }
                if(r==0){
                    found = true;
                    System.out.println("BAD "+i);
                    break;
                }
            }
            if(!found){
                System.out.println("GOOD");
            }
        }
        sc.close();
    }
}
