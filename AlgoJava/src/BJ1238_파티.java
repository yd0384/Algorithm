import java.io.*;
import java.util.*;
public class BJ1238_파티 {
    private static class Edge{
        int v, w;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    private static class Info{
        int node, distance;
        public Info(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
        public int getDistance() {
            return distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Edge>> map = new ArrayList<>();
        List<List<Edge>> from = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
            from.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map.get(u).add(new Edge(v, w));
            from.get(v).add(new Edge(u, w));
        }
        int[] ItoX = new int[N+1];
        int[] XtoI = new int[N+1];
        for (int i = 1; i <= N; i++) {
            if(i!=X){
                ItoX[i] = Integer.MAX_VALUE;
                XtoI[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(Info::getDistance));
        pq.add(new Info(X, 0));
        Info current = null;
        while(!pq.isEmpty()){
            current = pq.poll();
            for(Edge next : map.get(current.node)){
                if(XtoI[next.v] > next.w + current.distance){
                    XtoI[next.v] = next.w + current.distance;
                    pq.add(new Info(next.v, XtoI[next.v]));
                }
            }
        }
        pq = new PriorityQueue<>(Comparator.comparingInt(Info::getDistance));
        pq.add(new Info(X, 0));
        current = null;
        while(!pq.isEmpty()){
            current = pq.poll();
            for(Edge next : from.get(current.node)){
                if(ItoX[next.v] > next.w + current.distance){
                    ItoX[next.v] = next.w + current.distance;
                    pq.add(new Info(next.v, ItoX[next.v]));
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(answer < ItoX[i] + XtoI[i]){
                answer = ItoX[i] + XtoI[i];
            }
        }
        System.out.println(answer);
    }
}
