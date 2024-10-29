package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_지능형기차_2460 {

    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxMember = 0;
        int currentMember = 0;
        
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            currentMember -= out;
            currentMember += in;

            if (maxMember < currentMember) maxMember = currentMember;
        }

        System.out.println(maxMember);
    }
}
