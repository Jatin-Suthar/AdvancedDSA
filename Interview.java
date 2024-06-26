import java.util.HashMap;
import java.util.Map;

public class Interview {

    public static void main(String[] args) {
        String s = "My name is Jatin Suthar";
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(Character.toLowerCase(c), map.getOrDefault(Character.toLowerCase(c), 0)+1);
        }
        System.out.println(map);
        for(char c: map.keySet()) {
            if(map.get(c)>1 && c!=' ') {
                System.out.print(c + " ");
            }
        }
    }

}
