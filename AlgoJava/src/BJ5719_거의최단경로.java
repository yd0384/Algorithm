import java.util.*;
import java.io.*;
public class BJ5719_거의최단경로 {
    static List<List<Edge>> Map;
    static List<List<Integer>> from;
    static int[] Distance;
    static int N, M, S, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int MAXDISTANCE = 10000001;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            //입력종료 조건
            if(N==0 && M==0){
                break;
            }

            Map = new ArrayList<>();
            from = new ArrayList<>();
            Distance = new int[N];
            //리스트초기화
            for (int i = 0; i < N; i++) {
                Map.add(new ArrayList<>());
                from.add(new ArrayList<>());
                Distance[i] = MAXDISTANCE;
            }
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            //입력 받아서 인접 리스트 Map에 간선 저장
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                Map.get(u).add(new Edge(v, w));
            }
            //다익스트라
            PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(Info::getD));
            from.get(S).add(S);
            Info now;
            pq.add(new Info(S, 0));
            Distance[S] = 0;
            while(!pq.isEmpty()){
                now = pq.poll();
    
                if(now.d > Distance[now.v]){
                    continue;
                }

                for(Edge e:Map.get(now.v)){
                    if(Distance[e.v] > Distance[now.v] + e.w){
                        Distance[e.v] = Distance[now.v] + e.w;
                        pq.add(new Info(e.v, Distance[now.v] + e.w));
                        from.get(e.v).clear();
                        from.get(e.v).add(now.v);
                    }
                    else if(Distance[e.v] == Distance[now.v] + e.w){
                        from.get(e.v).add(now.v);
                    }
                }
            }
            //목적지로 가는 경로가 존재하지 않을때
            if(Distance[D]==MAXDISTANCE){
                sb.append("-1\n");
                continue;
            }
            //ArrayList의 삭제연산은 느림, 변수를 사용해 마킹하는 방법으로 변경
            removeEdge(D);
            
            //다익스트라 다시하기위한 초기화
            Distance = new int[N];
            for (int i = 0; i < N; i++) {
                Distance[i] = MAXDISTANCE;
            }

            pq.add(new Info(S, 0));
            Distance[S] = 0;
            //removed가 마킹되지 않은 간선에 대해서 다익스트라
            while(!pq.isEmpty()){
                now = pq.poll();
                
                if(now.d > Distance[now.v]){
                    continue;
                }

                for(Edge e:Map.get(now.v)){
                    if(!e.removed){
                        if(Distance[e.v] > Distance[now.v] + e.w){
                            Distance[e.v] = Distance[now.v] + e.w;
                            pq.add(new Info(e.v, Distance[now.v] + e.w));
                        }
                    }
                }
            }
            
            if(Distance[D]==MAXDISTANCE){
                sb.append("-1\n");
            }
            else{
                sb.append(Distance[D]+"\n");
            }
        }
        System.out.print(sb);
    }
    private static void removeEdge(int v){
        if(v==S){
            return;
        }
        for(int u: from.get(v)){
            for(Edge e: Map.get(u)){
                if(!e.removed && e.v == v){
                    e.removed = true;
                    removeEdge(u);
                }
            }
        }
    }
    private static class Edge{
        int v, w;
        boolean removed;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
            this.removed = false;
        }
    }
    private static class Info{
        int v, d;
        public Info(int v, int d){
            this.v = v;
            this.d = d;
        }
        public int getD() {
            return d;
        }
    }
}
