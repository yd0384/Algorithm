import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BJ1713_후보추천하기{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        int[] vote = new int[total];
        Candidate[] people = new Candidate[101];
        for(int i=0;i<input.length;i++){
            vote[i] = Integer.parseInt(input[i]);
        }
        List<Candidate> photozone = new ArrayList<Candidate>();
        int index = 0;
        for(int v:vote){
            if(people[v]==null){
                people[v] = new Candidate(0, v, 0, false);
            }
            if(people[v].isIn==true){
                people[v].votes++;
            }
            else{
                if(photozone.size() == N){
                    Collections.sort(photozone);
                    Candidate c = photozone.remove(0);
                    c.isIn = false;
                }
                people[v].votes = 1;
                people[v].isIn = true;
                people[v].index = index;
                photozone.add(people[v]);    
            }
            index++;
        }
        Collections.sort(photozone, Comparator.comparingInt(o->o.number));
        String output = "";
        for(Candidate c:photozone){
            output += c.number;
            output += ' ';
        }
        output.substring(0, output.length()-2);
        System.out.println(output);
        sc.close();
    }
    public static class Candidate implements Comparable<Candidate>{
        int index;
        int number;
        int votes;
        boolean isIn;

        public Candidate(int index, int number, int votes, boolean isIn){
            this.index=index;
            this.number=number;
            this.votes = votes;
            this.isIn = isIn;
        }

        @Override
        public int compareTo(Candidate c){
            int comp1 = Integer.compare(votes, c.votes);
            if(comp1==0){
                return Integer.compare(index, c.index);
            }
            else{
                return comp1;
            }
        }   
    }
}