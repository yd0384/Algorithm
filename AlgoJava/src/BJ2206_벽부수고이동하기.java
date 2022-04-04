import java.util.*;
import java.io.*;
public class BJ2206_벽부수고이동하기 {
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};
    static int N;
    static int M;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int minDistance = INF;
        int[][] map = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            String line = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        Queue<Actor> queue = new LinkedList<>();
        Actor current = new Actor(1, 1, 1, 1);
        queue.add(current);
        while(!queue.isEmpty()) {
            current = queue.poll();
            current.mark();
            if(current.getY() == N && current.getX() == M) {
                if(minDistance > current.getDistance()) {
                    minDistance = current.getDistance();
                }
            }
            for(int i = 0; i<4; i++) {
                int my = current.getY() + dy[i];
                int mx = current.getX() + dx[i];
                if(my > 0 && mx > 0 && my <= N && mx <= M) {
                    if(!current.isVisited(my, mx)) {
                        if(current.getChance() == 1) {
                            if(map[my][mx] == 1) {
                                queue.add(current.move(my, mx, 0));
                            }
                        }
                        if(map[my][mx] == 0) {
                            queue.add(current.move(my, mx, current.getChance()));
                        }
                    }
                }
            }
        }
        if(minDistance == INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(minDistance);
        }

    }
    private static class Actor {
        private int y;
        private int x;
        private int chance;
        private int distance;
        private Map<Integer[], Integer> visited;
        public Actor(int y, int x, int chance, int distance) {
            this.y = y;
            this.x = x;
            this.chance = chance;
            this.distance = distance;
            this.visited = new HashMap<>();
        }
        public Actor(int y, int x, int chance, int distance, Map<Integer[], Integer> visited) {
            this.y = y;
            this.x = x;
            this.chance = chance;
            this.distance = distance;
            this.visited = new HashMap<Integer[], Integer>(visited);
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public int getChance() {
            return chance;
        }
        public int getDistance() {
            return distance;
        }
        public void mark() {
            Integer[] tmp = {y, x};
            visited.put(tmp, distance);
        }
        public Actor move(int my, int mx, int chance) {
            return new Actor(my, mx, chance, distance+1, visited);
        }
        public boolean isVisited(int my, int mx) {
            Integer[] tmp = {my, mx};
            return (visited.get(tmp)!=null);
        }
    }
}
