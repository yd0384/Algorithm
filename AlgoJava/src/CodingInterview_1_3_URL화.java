import java.lang.StringBuilder;
public class CodingInterview_1_3_URL화 {
    public static void main(String[] args){
        System.out.println(URLify("Hello World everyone!!!"));
    }
    public static String URLify(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                sb.append("%20");
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
