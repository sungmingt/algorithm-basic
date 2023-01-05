package basic.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐2_18258 { //LinkedList로 구현해보기

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringBuilder sb = new StringBuilder();
        StringTokenizer command;
        for (int i = 0; i < N; i++) {
            command = new StringTokenizer(br.readLine(), " ");

            switch (command.nextToken()) {
                case "push" :
                    push(Integer.parseInt(command.nextToken()));
                    break;
                case "pop" :
                    sb.append(pop() + "\n");
                    break;
                case "size" :
                    sb.append(size() + "\n");
                    break;
                case "empty" :
                    sb.append(empty() + "\n");
                    break;
                case "front" :
                    sb.append(front() + "\n");
                    break;
                case "back" :
                    sb.append(back() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    static int size;

    static void push(int x) {
        arr[size] = x;
        size++;
    }

    static int pop() {
        int result = 0;

        if (size == 0) {
            return -1;
        } else {
            result = arr[0];
            arr[0] = 0;
        }

        for (int i = 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }

        size--;
        return result;
    }

    static int size() {
        return size;
    }

    static int empty() {
        if(size == 0) return 1;
        else return 0;
    }

    static int front() {
        if (size == 0) {
            return -1;
        } else {
            return arr[0];
        }
    }

    static int back(){
        if(size == 0) return -1;
        else return arr[size - 1];
    }

}
