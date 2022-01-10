import java.util.HashMap;
public class CodingInterview_1_2_순열_확인 {
    public static void main(String[] args){
        System.out.println(check_permutation("hello","elolh"));
        System.out.println(check_permutation("world", "wolrd"));
    }
    public static boolean check_permutation(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch:str1.toCharArray()){
            if(map.get(ch)==null){
                map.put(ch, 1);
            }
            else{
                map.replace(ch, map.get(ch)+1);
            }
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch:str2.toCharArray()){
            if(map2.get(ch)==null){
                map2.put(ch, 1);
            }
            else{
                map2.replace(ch, map2.get(ch)+1);
            }
        }
        for(char ch:map.keySet()){
            if(map2.get(ch)!=map.get(ch)){
                return false;
            }
        }
        return true;
    }
}
