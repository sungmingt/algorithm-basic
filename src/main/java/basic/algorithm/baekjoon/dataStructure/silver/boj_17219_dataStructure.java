package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_17219_dataStructure {

    static int N, M;
    static Map<String, String> passwords = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String domain = st.nextToken();
            String password = st.nextToken();
            passwords.put(domain, password);
        }

        while (M-- > 0) {
            String targetDomain = br.readLine();
            String pw = passwords.get(targetDomain);
            sb.append(pw).append("\n");
        }

        System.out.println(sb);
    }
}
