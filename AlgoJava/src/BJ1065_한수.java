import java.util.Scanner;

public class BJ1065_한수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 99;
        if(N<100){
            System.out.println(N);
        }
        else{
            for (int i = 100; i <=N; i++) {
                char[] numarr = Integer.toString(i).toCharArray();
                int diff=0, tmp=0;
                boolean success = true;
                for (int j = 1; j < numarr.length; j++) {
                    if(j==1){
                        diff = numarr[j]-numarr[j-1]; 
                    }
                    else{
                        tmp = numarr[j]-numarr[j-1];
                        if(diff!=tmp){
                            success = false;
                            break;
                        }    
                    }
                }
                if(success){
                    result++;
                }
            }
            System.out.println(result);
        }
        sc.close();
    }
}
//1부터 N까지
//1~99는 무조건 한수

