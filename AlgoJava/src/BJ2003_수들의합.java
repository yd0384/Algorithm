import java.util.Scanner;

public class BJ2003_수들의합{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int low = 0;
        int high = 0;
        int result = 0;
        int sum = arr[0];
        while(true){            
            if(sum < M){
                high++;
                if(high==N){
                    break;
                }
                sum+=arr[high];
            }
            else{
                if(sum==M){
                    result++;
                }
                sum-=arr[low];
                low++;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
//2개의 포인터 low, high로
//low부터 high까지의 합 sum
//sum>M => low++
//sum<M => high++
//sum==M => 답 증가, low++