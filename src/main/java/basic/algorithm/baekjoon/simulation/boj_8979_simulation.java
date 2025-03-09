package basic.algorithm.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_8979_simulation {

    static int N;
    static int T;
    static int rank = 1;
    static int[][] medals;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        T = Integer.parseInt(input[1]);
        medals = new int[N + 1][4];

        for (int i = 1; i < medals.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int countryNumber = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            medals[countryNumber][1] = gold;
            medals[countryNumber][2] = silver;
            medals[countryNumber][3] = bronze;
        }

        //메달의 개수를 2차원 배열에 저장한다. (medals[1][1] -> 1번 국가의 금메달 개수)
        //모두 입력받은 후, 2차원 배열을 순회하며 T 국가보다 높은 순위인지 체크한다. (금-은-동 순으로 비교)
        //만일 더 높은 순위일 경우, rank++ 처리
        //같은 순위일 경우 그대로 pass한다. (공동이기 때문에 순위가 밀려나지 않으므로)

        for (int i = 1; i < medals.length; i++) {
            if(i == T) continue;

            //T 국가와 비교하기
            if (medals[i][1] > medals[T][1]) {
                rank++;
            } else if(medals[i][1] == medals[T][1]){
                if (medals[i][2] > medals[T][2]) {
                    rank++;
                } else if(medals[i][2] == medals[T][2]){
                    if (medals[i][3] > medals[T][3]) {
                        rank++;
                    }
                }
            }
        }

        System.out.println(rank);
    }
}
