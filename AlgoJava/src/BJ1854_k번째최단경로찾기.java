import java.io.*;
import java.util.*;

public class BJ1854_k번째최단경로찾기 {
    static int n, m, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        List<List<Info>> Map = new ArrayList<>();
        List<PriorityQueue<Integer>> Distance = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            Map.add(new ArrayList<>());
            Distance.add(new PriorityQueue<>(Collections.reverseOrder()));
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Map.get(a).add(new Info(b, c));
        }
        int current = 1;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(Info::getDistance)); 
        Distance.get(current).add(0);
        pq.add(new Info(1, 0));
        while(!pq.isEmpty()){
            Info now = pq.poll();

            if(now.distance > Distance.get(now.dest).peek()) {
                continue;
            }

            for(Info next:Map.get(now.dest)){
                if(Distance.get(next.dest).size() < k){
                    Distance.get(next.dest).add(now.distance + next.distance);
                    pq.add(new Info(next.dest, now.distance + next.distance));
                }
                else if(Distance.get(next.dest).peek() < (now.distance + next.distance)){
                    Distance.get(next.dest).poll();
                    Distance.get(next.dest).add(now.distance + next.distance);
                    pq.add(new Info(next.dest, now.distance + next.distance));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(Distance.get(i).size()!=k){
                sb.append("-1\n");
            }
            else{
                sb.append(Distance.get(i).poll()+"\n");
            }
        }
        System.out.print(sb);
    }
    public static class Info{
        int distance, dest;
        public Info(int dest, int distance){
            this.distance = distance;
            this.dest = dest;
        }
        public int getDistance() {
            return distance;
        }
    }
}
