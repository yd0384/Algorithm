import java.io.*;
import java.util.*;
public class BJ4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        int total = 0;
        Map<String, Integer> map = new HashMap<>();
        while((name = br.readLine()) != null){
            if(map.get(name) == null){
                map.put(name, 1);
            }
            else{
                map.put(name, map.get(name)+1);
            }
            total++;
        }
        StringBuilder sb = new StringBuilder();
        String[] keys = map.keySet().toArray(new String[map.size()]);
        Arrays.sort(keys);
        for(int i = 0; i < keys.length; i++){
            sb.append(keys[i] + " " + String.format("%.4f", 100 * (double)(map.get(keys[i])) / total) + "\n");
        }
        System.out.print(sb);
    }
}
