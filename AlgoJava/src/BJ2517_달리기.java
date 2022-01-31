import java.util.*;
import java.io.*;
public class BJ2517_달리기 {
    static int S, N;
    static long[] indexedTree;
    static List<Integer> skill;
    static Map<Integer, Integer> order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        skill = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        order = new HashMap<>();
        for(int i=1; i<=N; i++){
            int s = Integer.parseInt(br.readLine());
            order.put(s, i);
            skill.add(s);
        }
        skill.sort(Comparator.reverseOrder());
        S = 1;
        while(S <= N){
            S*=2;
        }
        indexedTree = new long[S*2];
        long[] answer = new long[N+1];
        for(int i=0; i<N; i++){
            update(order.get(skill.get(i)));
            answer[order.get(skill.get(i))] = query(1, order.get(skill.get(i)));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(answer[i]+"\n");
        }
        System.out.print(sb);

    }
    private static void update(int target){
        target += S-1;
        indexedTree[target] = 1;
        while(target > 1){
            target >>= 1;
            indexedTree[target] = indexedTree[target*2] + indexedTree[target*2 + 1];
        }
    }
    private static long query(int left, int right){
        left += S-1;
        right += S-1;

        long ret = 0;
        
        while(left <= right){
            if(left%2==1){
                ret += indexedTree[left];
                left++;
            }
            if(right%2==0){
                ret += indexedTree[right];
                right--;
            }
            left >>= 1;
            right >>= 1;
        }

        return ret;
    }
}
