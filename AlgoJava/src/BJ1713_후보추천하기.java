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
        for(int i=0;i<input.length;i++){
            vote[i] = Integer.parseInt(input[i]);
        }
        List<Candidate> photozone = new ArrayList<Candidate>();
        int index = 0;
        for(int v:vote){
            boolean found = false;
            for(Candidate c: photozone){
                if(c.number==v){
                    c.votes++;
                    found=true;
                    break;
                }
            }    
            if(!found){
                if(photozone.size()<N){
                    photozone.add(new Candidate(index, v, 1));
                }
                else{
                    Collections.sort(photozone);
                    photozone.remove(0);
                    photozone.add(new Candidate(index, v, 1));
                }
            }
            index++;
        }
        Collections.sort(photozone, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                return Integer.compare(o1.number, o2.number);
            }
        });
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
        public Candidate(int index, int number, int votes){
            this.index=index;
            this.number=number;
            this.votes = votes;
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