import java.util.*;
public class BJ2447_별찍기10 {
    private static String[] map; 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new String[N];
        map[0] = "*";
        int n = 1;
        int k = 0;
        
        while(n != N){
            n *= 3;
            k++;
        }
        
        for (int i = 1; i <= k; i++) {
            drawPattern(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(map[i] + "\n");
        }
        System.out.print(sb);
        sc.close();
    }
    private static void drawPattern(int k){
        int n = (int)Math.pow(3, k);
        int beforeN = n/3;
        String[] before = new String[n/3];
        for (int i = 0; i < n/3; i++) {
            before[i] = new String(map[i]);
        }
        for(int i=0; i<n; i++){
            if(i/beforeN==1){
                map[i] = before[i%beforeN] + " ".repeat(beforeN) + before[i%beforeN];
            }
            else{
                map[i] = before[i%beforeN].repeat(3);
            }
        }
    }
}
