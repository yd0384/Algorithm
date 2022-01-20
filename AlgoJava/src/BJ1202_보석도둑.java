import java.io.*;
import java.util.*;

public class BJ1202_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewel> PQ = new PriorityQueue<>(Collections.reverseOrder());
        List<Jewel> jewels = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Integer.compare(o1.M, o2.M);
            }
        });
        Collections.sort(bags);
        long answer = 0;
        int i=0;
        for(int bag: bags){
            while(i<jewels.size()){
                if(jewels.get(i).M<=bag){
                    PQ.add(jewels.get(i));
                    i++;
                }
                else{
                    break;
                }
            }
            Jewel poll = PQ.poll();
            if(poll==null){
                continue;
            }
            else{
                answer+=(long)poll.V;
            }
        }
        System.out.println(answer);

    }
    public static class Jewel implements Comparable<Jewel>{
        private int M;
        private int V;
        public Jewel(int M, int V){
            super();
            this.M = M;
            this.V = V;
        }
        @Override
        public int compareTo(Jewel j) {
            return Integer.compare(V, j.V);
        }
        public int getM(){
            return M;
        }
        public int getV(){
            return V;
        }
    }
}
