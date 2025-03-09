package basic.algorithm.baekjoon.dataStructure.stack.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17299_stack {

    static int N;
    static int[] arr;
    static int[] cnt;
    static int[] ans;
    static int maxCount = -1;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1 2 3 4 3 2
        //-1
        //-1 -1
        //-1 -1 -1
        //-1 -1 -1 -1
        //3이 두번째 등장 -> 3 3 -1 3 -1
        //2가 두번째 등장 -> 2 -1 -1 3 -1 -1
        //  -> 뒤에 오는 값에 따라 이전 값이 계속 바뀐다. 그럼 스택에서 언제 pop 해야하는가?
        //  -> 먼저 등장 횟수를 별도의 배열에 담고, 뒤에서부터 탐색한다.
        //스택에는 값을 담는다. 값을 기준으로 등장횟수(cnt[])를 조회하기 때문에

        //먼저, arr[]을 입력 받으면서 등장 횟수를 cnt[]에 저장
        //배열의 뒤에서부터 탐색.
        //현재값의 등장 횟수가 stack의 top보다 적을때 push + 오등큰수 입력 (ans[i])
        //현재값의 등장 횟수가 stack의 top보다 많을때 pop
        //  현재값의 오등큰수는 아직 없다. 다음 값의 오등큰수도 stack의 top은 아니다
        //  하지만, 현재값의 오등큰수를 찾기 위해서는 stack을 더 탐색해야한다.

        //init
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = new int[1000001];
        ans = new int[N];
        stack = new Stack<>();

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            cnt[input]++;
        }

        for (int i = N - 1; i >= 0; i--) {
            int val = arr[i];

            if (stack.isEmpty()) {
                stack.push(val);
                ans[i] = -1;
                maxCount = cnt[val];
                continue;
            }

            Integer top = stack.peek();

            if (cnt[val] >= maxCount) {
                stack.clear();
                stack.push(val);
                ans[i] = -1;
                maxCount = cnt[val];
                continue;
            }

            if (cnt[val] < cnt[top]) {
                stack.push(val);
                ans[i] = top;
            }
            else {
                while (!stack.isEmpty()) {
                    Integer t = stack.peek();
                    if (cnt[val] < cnt[t]) {
                        stack.push(val);
                        ans[i] = t;
                        break;
                    }

                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : ans) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
