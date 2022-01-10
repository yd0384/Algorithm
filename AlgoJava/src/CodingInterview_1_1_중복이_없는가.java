import java.util.HashMap;
public class CodingInterview_1_1_중복이_없는가 {
    public static void main(String[] args){
        System.out.println(not_duplicate("hello"));
        System.out.println(not_duplicate("world"));
        System.out.println(not_duplicate_without_hashmap("hello"));
        System.out.println(not_duplicate_without_hashmap("world"));
    }
    public static boolean not_duplicate(String str1){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch:str1.toCharArray()){
            if(map.get(ch)==null){
                map.put(ch, 0);
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static boolean not_duplicate_without_hashmap(String str1){
        boolean[] check = new boolean[128];
        for(char ch: str1.toCharArray()){
            if(!check[(int)ch]){
                check[(int)ch]=true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
