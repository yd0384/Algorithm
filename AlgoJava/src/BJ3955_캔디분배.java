import java.io.*;
import java.util.StringTokenizer;
public class BJ3955_캔디분배 {
    public static void main(String[] args) throws IOException {
        // X: 인당 나눠줄 사탕의 수
        // Y: 사탕 봉지의 수
        // A: 파티에 참가하는 사람 수
        // B: 한 봉지의 사탕 수
        // A*x + 1  = B*y
        // A(-x) + By = 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long A = Integer.parseInt(st.nextToken());
            long B = Integer.parseInt(st.nextToken());
            EGResult egr = extendedGcd(A, B);
            // 2. 초기 해 구하기
            // x0 = s * C / D
            // y0 = t * C / D
            long x0 = egr.s, y0 = egr.t, D = egr.r; 
            // 1. 해 검증
            // D = gcd(A, B) => egcd(A, B).r
            // Ax + By = C 일때 C%D == 0 이어야 해를 가질 수 있음 : 베주 방정식
            // C % D != 0 -> 해가 없음
            // C가 1 이므로 D가 1이어야 함 
            if(D != 1){
                sb.append("IMPOSSIBLE\n");
                continue;
            }
            // 3. 일반 해 구하기
            // x = x0 + B / D * k
            // y = y0 - A / D * k

            // 4. k의 범위
            // 문제에서 D는 1
            // x < 0
            // x0 + B * k < 0
            // k < - x0 / B

            // 0 < y <= 1e9
            // 0 < y0 - A * k <= 1e9
            // -y0 < -A * k <= 1e9 - y0
            // ( y0 - 1e9 ) / A <= k < y0 / A

            // 나눗셈 소수로하기
            // ceil - 1 하면 경계값 찾을 수 있다.
            // ( y0 - 1e9 ) / A <= k < y0 / A
            //                     k < - x0 / B
            double lowerBoundDouble, upperBoundDouble;
            lowerBoundDouble = (y0 - 1e9) / (double)A;
            upperBoundDouble = Math.min(y0 / (double)A, -x0 / (double)B);
            long lowerBound = (long)Math.ceil(lowerBoundDouble);
            long upperBound = (long)Math.ceil(upperBoundDouble) -1;
            // 5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.
            if(lowerBound <= upperBound){
                long y = y0 - A*lowerBound;
                sb.append(y+"\n");
            } 
            else{
                sb.append("IMPOSSIBLE\n");
            }
        }
        System.out.println(sb);
    }
    static EGResult extendedGcd(long a, long b) {
        long s0 = 1; 
        long t0 = 0;
        long r0 = a;

        long s1 = 0; 
        long t1 = 1;
        long r1 = b;

        long tmp;
        while(r1 != 0){
            long q = r0 / r1;
            
            tmp = r0 - q*r1;
            r0 = r1;
            r1 = tmp;

            tmp = s0 - q*s1;
            s0 = s1;
            s1 = tmp;

            tmp = t0 - q*t1;
            t0 = t1;
            t1 = tmp;
        }
        return new EGResult(s0, t0, r0);

    }

    public static class EGResult {
        long s;
        long t;
        long r;

        public EGResult(long s, long t, long r){
            super();
            this.s = s;
            this.t = t;
            this.r = r;
        }
    }
}
