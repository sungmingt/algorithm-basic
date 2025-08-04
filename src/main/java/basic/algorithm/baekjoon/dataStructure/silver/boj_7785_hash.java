package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.*;
import java.util.*;

public class boj_7785_hash {

    static int N;
    static Set<String> latest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        latest = new HashSet<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();

            if (log.equals("enter")) {
                latest.add(name);
            } else {
                latest.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();

        latest.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(n -> sb.append(n).append("\n"));

        System.out.println(sb);
    }
}
