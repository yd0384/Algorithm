import java.util.*;
import java.io.*;

public class BJ1208_부분수열의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        Stack<Integer> positive_and_zero = new Stack<>();
        Stack<Integer> negative = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] >= 0) {
                positive_and_zero.push(arr[i]);
            } else {
                negative.push(arr[i]);
            }
        }
        int count = 0;
        Queue<Container> queue = new LinkedList<>();
        queue.add(new Container(positive_and_zero, negative, 0));
        while (!queue.isEmpty()) {
            Container current = queue.poll();
            Stack<Integer> current_positive_and_zero = current.positive_and_zero;
            Stack<Integer> current_negative = current.negative;
            int current_x = current.x;
            if (current.x < S) {
                if (!current_positive_and_zero.isEmpty()) {
                    int item = current_positive_and_zero.pop();
                    queue.add(new Container(current_positive_and_zero, current_negative, current_x));
                    if (current_x + item == S) {
                        count++;
                    }
                    queue.add(new Container(current_positive_and_zero, current_negative, current_x + item));
                }
            } else {
                if (!current_negative.isEmpty()) {
                    int item = current_negative.pop();
                    queue.add(new Container(current_positive_and_zero, current_negative, current_x));
                    if (current_x + item == S) {
                        count++;
                    }
                    queue.add(new Container(current_positive_and_zero, current_negative, current_x + item));
                }
            }
            System.out.println(current_x);
        }
        System.out.println(count);
    }

    static class Container {
        Stack<Integer> positive_and_zero;
        Stack<Integer> negative;
        int x;

        public Container(Stack<Integer> positive_and_zero, Stack<Integer> negative, int x) {
            this.positive_and_zero = positive_and_zero;
            this.negative = negative;
            this.x = x;
        }
    }
}
