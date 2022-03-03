import java.util.*;
import java.io.*;
public class BJ1916_최소비용구하기 {
    public static class Info{
        private int node, distance;
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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<HashMap<Integer, Integer>> map = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            map.add(new HashMap<>());
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(map.get(u).get(v)==null){
                map.get(u).put(v, w);
            }
            else{
                if(map.get(u).get(v) > w){
                    map.get(u).put(v, w);
                }
            }
        }
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(Info::getDistance));
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] D = new int[N+1];
        for (int i = 0; i <= N; i++) {
            if(i!=a){
                D[i] = 987654321;
            }
        }
        pq.add(new Info(a, 0));
        while(!pq.isEmpty()){
            Info currentInfo = pq.poll();
            for(int key : map.get(currentInfo.node).keySet()){
                if(D[key] > D[currentInfo.node] + map.get(currentInfo.node).get(key)){
                    D[key] = D[currentInfo.node] + map.get(currentInfo.node).get(key);
                    pq.add(new Info(key, D[key]));
                }
            }
        }
        System.out.println(D[b]);
    }
}
