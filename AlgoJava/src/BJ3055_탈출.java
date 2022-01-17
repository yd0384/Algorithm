import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class BJ3055_탈출 {
    static int R, C;
    static char[][] map;
    static int[][] dp;
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};
    static Queue<Point> queue;
    static boolean success = false;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            R = Integer.parseInt(input[0]);
            C = Integer.parseInt(input[1]);
            map = new char[R][C];
            dp = new int[R][C];
            Point st = null;
            queue = new LinkedList<>();

            for(int r=0;r<R;r++){
                String row = br.readLine();
                for(int c=0;c<C;c++){
                    map[r][c] = row.charAt(c);
                    if(map[r][c]=='S'){
                        st = new Point(r, c, 'S');
                    }
                    else if(map[r][c]=='*'){
                        queue.add(new Point(r, c, '*'));
                    }
                }
            }
            queue.add(st);
            while(!queue.isEmpty()){
                //1. 큐에서 꺼내옴
                Point p = queue.poll();
                //2. 목적지인가?
                if(p.type=='D'){
                    System.out.println(dp[p.y][p.x]);
                    success=true;
                    break;
                }
                //3. 연결된 곳을 순회
                for(int i=0;i<4;i++){
                    int ty = p.y + MY[i];
                    int tx = p.x + MX[i];
                    
                    
                    if(0 <= ty && ty < R && 0 <= tx && tx < C){ //4. 갈 수 있는가? 맵을 벗어나지 않고
                        if(p.type == '.' || p.type == 'S'){
                            //4. 갈수있는가?(고슴도치) . or D, 방문하지 않은 곳
                            if((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx]==0 ){
                                 //5. 체크인 -> dp에 현재 + 1을 기록
                                dp[ty][tx] = dp[p.y][p.x] + 1;
                                //6. 큐에 넣음
                                queue.add(new Point(ty, tx, map[ty][tx]));
                            }
                        }else if(p.type == '*'){
                            //4. 갈수있는가?(물) .
                            if(map[ty][tx]=='.' || map[ty][tx] == 'S'){
                                //5. 체크인 -> 지도에 * 표기
                                map[ty][tx] = '*';
                                //6. 큐에 넣음
                                queue.add(new Point(ty, tx, '*'));
                            }
                        }
                    }
                }
            }   
            if(!success){
                System.out.println("KAKTUS");
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static class Point{
        private int y;
        private int x;
        private char type;
        public Point(int y, int x, char type){
            super();
            this.y = y;
            this.x = x;
            this.type = type;
        }
        @Override
        public String toString() { return "[y="+y+", x="+x+", type="+type+"]"; }
    }
}
/*
    고슴도치
    1. 큐에서 꺼내옴
    2. 목적지인가? D에 도착했나?
    3. 연결된곳을 순회: 좌우위아래
        4. 갈수있는가? (1) 맵 영역, (2) *이 인접해있지 않은 . => *이 먼저 이동해서 해결 (3) 방문하지 않은 곳
        5. 체크인: 지도사이즈만큼의 인트배열에 최소 이동시간을 체크하자
        6. 큐에 넣음
    물
    1. 큐에서 꺼내옴
    2. 목적지인가? 생략
    3. 연결된곳을 순회: 좌우위아래
        4. 갈수있는가? (1) 맵 영역, (2) . (3) 방문하지 않은 곳
        5. 체크인: 지도사이즈만큼의 인트배열에 최소 이동시간을 체크하자
        6. 큐에 넣음
*/