package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_7785_hash {

    static int N;
    static Map<String, String> latest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        latest = new HashMap<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            latest.put(name, log);
        }

        StringBuilder sb = new StringBuilder();

        latest.keySet().stream()
                .filter(l -> latest.get(l).equals("enter"))
                .sorted(Comparator.reverseOrder())
                .forEach(n -> sb.append(n).append("\n"));

        System.out.println(sb);
    }
}
