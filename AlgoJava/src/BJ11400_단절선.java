import java.util.*;
import java.io.*;

public class BJ11400_단절선 {

    static List<List<Edge>> Adj;
    static int[] SearchOrder;
    static boolean[] isCutV;
    static int Order=0;
    static int Answer=0;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Adj = new ArrayList<>();
        for(int i=0; i<V+1; i++){
            Adj.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Adj.get(u).add(new Edge(u, v));
            Adj.get(v).add(new Edge(v, u));
        }
        SearchOrder = new int[V+1];
        isCutV = new boolean[V+1];
        for(int i=1; i<=V;i++){
            if(SearchOrder[i]==0){
                dfs(i, true);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++){
            if(isCutV[i]){
                Answer++;
                sb.append(i+" ");
            }
        }
        System.out.println(Answer);
        if(Answer>0){
            sb.setCharAt(sb.length()-1, '\n');
            System.out.print(sb);
        }
    }
    public static int dfs(int current, boolean isRoot){
        //체크인
        Order++;
        SearchOrder[current] = Order;
        int ret = Order;
        int child = 0;

        for(Edge next : Adj.get(current)) {
            if(SearchOrder[next.v] == 0) {
                child++;
                int low = dfs(next.v, false);
                if(!isRoot && low >= SearchOrder[current]){
                    isCutV[current] = true;
                }
                ret = Math.min(ret, low);
            }
            else{
                ret=Math.min(ret, SearchOrder[next.v]);
            }
        }
        if(isRoot){
            if(child>=2){
                isCutV[current] = true;
            }
        }
        return ret;
    }
    public static class Edge{
        int u, v;
        public Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
}
