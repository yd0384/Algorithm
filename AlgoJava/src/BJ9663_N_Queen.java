/*
import java.util.*;
public class BJ9663_N_Queen {
    static boolean[][] map;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new boolean[N][N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = DFS(0, i);
        }
        sc.close();
    }
    
    public static int DFS(int y, int x){
        if(!map[y][x]){
            marking(y, x);
        }
    }
    
    public static void marking(int y, int x){
        int[] DY = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] DX = {0, 1, 1, 1, 0, -1, -1, -1};
        for(int i=1; i < 2*N; i++){
            for(int j=0; j < 9; j++){
                int my = DY[j]*i;
                int mx = DX[j]*i;
                if(my >= 0 && mx >= 0 && my < N && mx < N){
                    map[my][mx]=true;
                }
            }
        }
    }
    
}
*/
//마킹이 아래에만 위치하니까 undo가 가능한 형식으로 다시 구현해보자