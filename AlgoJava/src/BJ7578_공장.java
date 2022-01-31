import java.io.*;
import java.util.*;
public class BJ7578_공장 {
    static int N, S;
    static int[] A;
    static int[] IndexedTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        A = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> B = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            B.put(Integer.parseInt(st.nextToken()), i);
        }
        S = 1;
        while(S < N){
            S*=2;
        }
        IndexedTree = new int[S*2];
        long answer = 0;
        for(int i=1; i<=N; i++){
            int key = B.get(A[i]);
            answer += query(key+1, N);
            update(key);
        }
        System.out.println(answer);
    }
    private static void update(int target){
        target += S - 1;
        IndexedTree[target] = 1;
        for(target>>=1; target!=0; target>>=1){
            IndexedTree[target] = IndexedTree[target*2] + IndexedTree[target*2+1];
        }
    }
    private static long query(int left, int right){
        long ret = 0;
        left += S - 1;
        right += S - 1;
        while(left <= right){
            if(left%2==1){
                ret += IndexedTree[left];
                left++;
            }          
            if(right%2==0){
                ret += IndexedTree[right];
                right--;
            }
            left>>=1;
            right>>=1;  
        }
        return ret;
    }
}
