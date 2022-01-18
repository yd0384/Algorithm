import java.io.*;
import java.util.*;
public class BJ2143_두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for(int i=0; i<M; i++){
            B[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= A.length; i++) {
            for(int j=0; j<=A.length-i;j++){
                long sum = 0;
                for(int k=0;k<i;k++){
                    sum += A[j+k];
                }
                subA.add(sum);
            }
        }
        for (int i = 1; i <= B.length; i++) {
            for(int j=0; j<=B.length-i;j++){
                long sum = 0;
                for(int k=0;k<i;k++){
                    sum += B[j+k];
                }
                subB.add(sum);
            }
        }
        Collections.sort(subA, Comparator.comparingLong(o->o));
        Collections.sort(subB, Comparator.comparingLong(o->o));
        int p1=0, p2=subB.size()-1;
        long cnt=0;
        boolean same = false;
        long cnt1=0; 
        long cnt2=0;
        long tmp1=0;
        long tmp2=0;
        while(true){
            //둘 다 중복을 벗어날 때까지 카운트
            //종료조건에서 중복상태인지 체크해야함
            if(same){
                if(subA.get(p1)!=tmp1 && subB.get(p2)!=tmp2){
                    same = false;
                    cnt += cnt1 * cnt2;
                    cnt1 = 0;
                    cnt2 = 0;
                }
                if(subA.get(p1)==tmp1){
                    p1++;
                    cnt1++;
                }
                if(subB.get(p2)==tmp2){
                    p2--;
                    cnt2++;
                }
            }else{
                //같을때 다음루프에 same으로 돌입
                if(subA.get(p1)+subB.get(p2)==T){
                    same=true;
                    cnt1++;
                    cnt2++;
                    tmp1 = subA.get(p1);
                    tmp2 = subB.get(p2);
                    p1++;
                    p2--;                
                }
                //합이 더 클때 p2를 왼쪽으로
                else if(subA.get(p1)+subB.get(p2)>T){
                    p2--;
                }
                //합이 더 작을때 p1을 오른쪽으로
                else{
                    p1++;
                }
            }
            //종료조건
            if(p1==subA.size() || p2 == -1){
                if(same){
                    if(p1==subA.size()){
                        while(p2>-1){
                            if(subB.get(p2)==tmp2){
                                cnt2++;
                                p2--;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    if(p2==-1){
                        while(p1<subA.size()){
                            if(subA.get(p1)==tmp1){
                                cnt1++;
                                p1++;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    cnt += cnt1 * cnt2;
                }
                break;                
            }
        }
        System.out.println(cnt);
    }
}
