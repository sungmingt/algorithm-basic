package basic.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 무인도여행_BFS {

    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] dX = {-1, 1, 0, 0};
        int[] dY = {0, 0, -1, 1};
        int[][] visited = new int[maps.length][maps[0].length()];
        Queue<Node> q = new LinkedList<>();

        //BFS
        //연결 조건 : (!= X && visited = 0) 여야함.

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {

                if (maps[i].charAt(j) == 'X' || visited[i][j] != 0) {
                    continue;
                }

                q.offer(new Node(j, i));
                visited[i][j] = maps[i].charAt(j) - '0';
                int totalNumber = visited[i][j];

                //BFS 시작
                while (!q.isEmpty()) {
                    Node curNode = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int newX = curNode.x + dX[k];
                        int newY = curNode.y + dY[k];

                        //움직일 수 있다면
                        if (canMove(newX, newY, maps[i].length(), maps.length)
                                && visited[newY][newX] == 0
                                && maps[newY].charAt(newX) != 'X') {

                            //새로운 map의 숫자를 추가
                            visited[newY][newX] = maps[newY].charAt(newX) - '0';
                            q.offer(new Node(newX, newY));

                            totalNumber += visited[newY][newX];
                        }
                    }
                }

                answer.add(totalNumber);
            }
        }

        int[] arrAnswer = answer.stream().mapToInt(o -> o).toArray();
        Arrays.sort(arrAnswer);

        return arrAnswer.length == 0 ? new int[]{-1} : arrAnswer;
    }

    public boolean canMove(int x, int y, int limitX, int limitY) {
        return 0 <= x && x < limitX && 0 <= y && y < limitY;
    }

    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
