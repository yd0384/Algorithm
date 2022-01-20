import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class BJ2042_구간합구하기 {
    static int N, M, K;
    static BigInteger[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        IndexedTree it = new IndexedTree();
        StringBuilder sb = new StringBuilder();
        tree = new BigInteger[it.S*2];
        for (int i = it.S; i < it.S*2; i++) {
            if(i<it.S+N){
                tree[i] = new BigInteger(br.readLine());
            }
            else{
                tree[i] = new BigInteger("0");
            }
            
        }
        for (int i = it.S-1; i > 0; i--) {
            tree[i] = tree[i*2].add(tree[i*2+1]);
        }

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==1){
                int target = Integer.parseInt(st.nextToken());
                BigInteger value = new BigInteger(st.nextToken());
                it.update(target, value);
            }
            else{
                int leftquery = Integer.parseInt(st.nextToken());
                int rightquery = Integer.parseInt(st.nextToken());
                sb.append(it.query(1, it.S, 1, leftquery, rightquery)+"\n");
            }
        }
        System.out.print(sb);
    }
    public static class IndexedTree{
        int S=1;
        
        public IndexedTree(){
            while(S<N){
                S*=2;
            }
        }

        public BigInteger query(int left, int right, int node, int leftquery, int rightquery){
            BigInteger ret = new BigInteger("0");
            if(left >= leftquery && right <= rightquery){
                return tree[node];
            }
            else if(left==right){
                return ret;
            }
            else if(left > rightquery || right < leftquery){
                return ret;
            }
            else{
                int mid = (left + right)/2;
                ret = ret.add(query(left, mid, node*2, leftquery, rightquery));
                ret = ret.add(query(mid+1, right, node*2 +1, leftquery, rightquery));
            }
            return ret;
        }
        public void update(int target, BigInteger value){
            BigInteger diff = value.subtract(tree[target+S-1]);
            int i = target+S-1;
            tree[i] = value;
            while(i>1){
                i/=2;
                tree[i] = tree[i].add(diff);
            }
        }
    }
}
