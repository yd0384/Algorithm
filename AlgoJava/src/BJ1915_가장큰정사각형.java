import java.util.*;
import java.io.*;
public class BJ1915_가장큰정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map1 = new int[n][m];
        int[][] map2 = new int[n][m];
        boolean found=false;
        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                map1[i][j] = input.charAt(j)-'0';
                if(map1[i][j]==1){
                    found = true;
                }
            }
        }
        if(!found){
            System.out.println(0);
        }
        else{
            int maxside = 0;
            
            while(found){
                found = false;
                for(int i=0; i<n-1; i++){
                    for(int j=0; j<m-1; j++){
                        if(map1[i][j] + map1[i+1][j] + map1[i][j+1] + map1[i+1][j+1] == 4){
                            map2[i][j] =  1;
                            found = true;
                        }
                        else{
                            map2[i][j] = 0;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        map1[i][j] = map2[i][j];
                        map2[i][j] = 0;
                    }
                }
                
                maxside++;
            }
            System.out.println(maxside * maxside);
        }
    }
}
