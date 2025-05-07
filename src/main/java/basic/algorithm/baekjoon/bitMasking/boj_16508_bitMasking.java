package basic.algorithm.baekjoon.bitMasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16508_bitMasking {

    static String str;
    static int N;
    static List<Book> bookList;
    static int minTotalPrice = 1600001;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = Integer.parseInt(br.readLine());

        bookList = new ArrayList<>();

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            String title = st.nextToken();
            bookList.add(new Book(price, title));
        }

        // 모든 부분집합 탐색 (1부터 시작: 최소 1권 선택)
        for (int i = 1; i < (1 << N); i++) {
            alpha = new int[26];
            int totalCost = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) { //j번째 책이 선택 된 책인 경우
                    totalCost += bookList.get(j).price;
                    for (char c : bookList.get(j).title.toCharArray()) {
                        alpha[c - 'A']++;
                    }
                }
            }

            if (canMakeTitle(alpha)) {
                minTotalPrice = Math.min(minTotalPrice, totalCost);
            }
        }

        System.out.println(minTotalPrice == 1600001 ? -1 : minTotalPrice);
    }

    static boolean canMakeTitle(int[] alpha) {
        int[] needed = new int[26];
        for (char c : str.toCharArray()) {
            needed[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] < needed[i]) return false;
        }

        return true;
    }

    static class Book {
        int price;
        String title;

        Book(int price, String title) {
            this.price = price;
            this.title = title;
        }
    }
}
