import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class SortTest {
    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(2, 2, 3);
        Item item3 = new Item(3, 1, 2);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        
        System.out.println(list);
        
        Collections.sort(list);

        System.out.println(list);

        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.c, o2.c);
            }
        });
        Collections.sort(list, Comparator.comparingInt(Item::getB) //.reversed().thenComparingInt(Item::getA));
        );
    }   
    
}
class Item implements Comparable<Item>{
    int a;
    int b;
    int c;

    public Item(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString(){
        return "{" +
                "a=" + a +
                ", b=" + b +
                ", c="+ c +
                "}";
    }

    //음수 : -
    //0 : -
    //양수 : Swap
    @Override
    public int compareTo(Item o){
        //return Integer.compare(a, o.a);
        if(a>o.a){
            return 1;
        }else if(a==o.a){
            return 0;
        }
        else{
            return -1;
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
