package basic.algorithm.baekjoon.recursive.bronze;

import java.util.Scanner;

public class 재귀의귀재_25501_재귀 {

    static int recursionCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            int palindrome = isPalindrome(str);
            System.out.println(palindrome + " " + recursionCount);
            recursionCount = 0;
        }
    }

    public static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    private static int recursion(String str, int firstIndex, int secondIndex) {
        recursionCount++;

        if(firstIndex >= secondIndex) {
            return 1;
        }
        if(str.charAt(firstIndex) != str.charAt(secondIndex)) {
            return 0;
        }

        return recursion(str, firstIndex + 1, secondIndex - 1);
    }
}
