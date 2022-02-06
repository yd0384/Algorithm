import java.util.*;
public class BJ1072_게임 {
    public static void main(String[] args) {
        long X;
        long Y;
        Scanner sc = new Scanner(System.in);
        X = sc.nextLong();
        Y = sc.nextLong();
        long Z = (Y*100/X) ;
        if(99<=Z){
            System.out.println(-1);
        }
        else{
            long plus = 1;
            long newZ = ((Y+plus)*100)/(X+plus);
            while(newZ == Z){
                plus <<= 1;
                newZ = ((Y+plus)*100)/(X+plus);
            }
            long left = 1;
            long right = plus;
            long mid = 0;
            while(left <= right){
                mid = (left + right) / 2;
                newZ = ((Y+mid)*100)/(X+mid);
                if(newZ > Z){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            if(((Y+mid)*100)/(X+mid) > Z){
                System.out.println(mid);
            }
            else{
                System.out.println(mid+1);
            }
        }
        sc.close();
    }
}
