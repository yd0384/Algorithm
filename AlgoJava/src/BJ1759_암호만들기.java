import java.util.Arrays;
import java.util.Scanner;
public class BJ1759_암호만들기 {
    static int L, C;
    static char[] vowel = {'a','e','i','o','u'};
    static char[] alpha;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        alpha = new char[input.length];
        for(int i=0;i<input.length;i++){
            alpha[i] = input[i].charAt(0);
        }
        Arrays.sort(alpha);
        DFS(0, "");
        sc.close();
    }
    public static void DFS(int i, String ret){
        if(ret.length()==L){
            int vowels = 0;
            int consonants = 0;
            for(char r:ret.toCharArray()){
                boolean flag = false;
                for(char c:vowel){
                    if(r==c){
                        vowels++;
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    consonants++;
                }
            }
            if(vowels>=1 && consonants>=2){
                System.out.println(ret);
            }
            return;
        }
        if(i>=C){
            return;
        }
        DFS(i+1, ret+alpha[i]);
        DFS(i+1, ret);
    }
}
/* 
    체크인: 생략가능
    목적지인가? 길이가 L인가? 모음 1개, 자음 2개 이상인가?
    연결된곳을 순회: 배열에서 본인 다음 인덱스의 영역이 연결됨
    갈 수 있는가? 생략가능 (정렬됐기 때문)
    간다 DFS 호출
    자음, 모음의 개수를 매개변수로 해서 계산시켜 갈 수도 있다.
*/