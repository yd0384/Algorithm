import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.*;

public class BJ1920_수찾기 {
    public static void main(String[] args) throws Exception {
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            A.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            B.add(Integer.parseInt(st.nextToken()));          
        }
        Collections.sort(A, Comparator.comparingInt(o->o));
        
        
        for (int i = 0; i < M; i++) {
            int high = N-1;
            int low = 0;
            boolean found = false;
            while(high>=low){
                int mid = (high+low)/2;
                if(B.get(i)==A.get(mid)){
                    found = true;
                    break;
                }
                else if(B.get(i)>A.get(mid)){
                    low = mid+1;
                }
                else{
                    high = mid - 1;
                }
            }
            if(!found){
                System.out.println(0);
            }
            else{
                System.out.println(1);
            }
        }

    }
}
