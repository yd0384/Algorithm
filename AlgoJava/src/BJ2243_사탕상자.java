import java.util.*;
import java.io.*;
public class BJ2243_사탕상자 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        IndexedTree it = new IndexedTree();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if(A==1){
                long B = Long.parseLong(st.nextToken());
                sb.append(it.query(1,B)+"\n");
            }
            else{
                int B = Integer.parseInt(st.nextToken());
                long C = Long.parseLong(st.nextToken());
                it.update(B, C);
            }
        }
        System.out.println(sb);
    }
    public static class IndexedTree{
        int S = 1048576;
        public IndexedTree(){
            tree = new long[S*2];
        }
        public void update(int target, long diff){
            int index = target+S-1;
            while(index>0){
                tree[index]+=diff;
                index/=2;
            }
        }
        public long query(int node, long Q){
            if(node<S){
                if(tree[node*2]<Q){
                    return query(node*2+1, Q-tree[node*2]);
                }
                else{
                    return query(node*2, Q);
                }
            }
            else{
                update(node-S+1, (long)-1);
                return node-S+1;
            }
        }
    }
}
