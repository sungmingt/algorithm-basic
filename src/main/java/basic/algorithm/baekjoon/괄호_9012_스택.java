package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 괄호_9012_스택 { //스택을 사용하지 않은 풀이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            int open = 0;
            int closed = 0;
            boolean isVPS = true;

            for (int j = 0; j < word.length(); j++) {

                if (word.charAt(j) == '(') open++;
                else closed++;

                if(open < closed){
                    isVPS = false;
                    break;
                }
            }

            if (open != closed) isVPS = false;

            if (isVPS) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
