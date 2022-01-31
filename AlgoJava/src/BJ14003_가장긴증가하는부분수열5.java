import java.io.*;
import java.util.*;
public class BJ14003_가장긴증가하는부분수열5{
    static long[] IndexedTree;
    static int S;
    static Map<Integer, Integer> map;
    static List<Integer> A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int order = 1;
        final int INF = 1000000001;
        map = new HashMap<>();
        A = new ArrayList<>();
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(map.getOrDefault(a, INF) == INF){
                map.put(a, order);
                A.add(a);
                order++;
            }
        }
        order--;
        S = 1;
        while(order > S){
            S<<=1;
        }
        IndexedTree = new long[S<<1];
        A.sort(Comparator.comparingInt(o->o));
        long value;
        for(int i=0; i<order; i++){
            value = query(1, map.get(A.get(i))) + 1;
            update(map.get(A.get(i)), value);
        }
        System.out.println(IndexedTree[1]);

    }
    private static void update(int target, long value){
        int index = target + S - 1;
        IndexedTree[index] = value;
        while(index!=1){
            index>>=1;
            IndexedTree[index] = Math.max(IndexedTree[index*2], IndexedTree[index*2 +1]);
        }
    }
    private static long query(int left, int right){
        left += S - 1;
        right += S - 1;
        long ret = 0;
        while(left <= right){
            if((left&1)==1){
                ret = Math.max(ret, IndexedTree[left]);
                left++;
            }
            if((right&1)==0){
                ret = Math.max(ret, IndexedTree[right]);
                right--;
            }
            left>>=1;
            right>>=1;
        }
        return ret;
    }
}
