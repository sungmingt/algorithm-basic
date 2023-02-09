package basic.algorithm.programmers.lv2;

public class 방문길이_탐색 {

    public int solution(String dirs) {
        int result = 0;

        boolean[][][] visited = new boolean[11][11][5];
        visited[5][5][0] = true;
        int initialX = 5;
        int initialY = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);

            if (command == 'U') {
                //범위 안이면
                if (initialY + 1 <= 10) {
                    //방문 안했으면
                    if (!visited[initialX][initialY + 1][1] && !visited[initialX][initialY][2]) {
                        visited[initialX][initialY + 1][1] = true;
                        result++;
                    }

                    initialY += 1;
                }
            } else if (command == 'D') {
                //범위 안이면
                if (initialY - 1 >= 0) {
                    //방문 안했으면
                    if (!visited[initialX][initialY - 1][2] && !visited[initialX][initialY][1]) {
                        visited[initialX][initialY - 1][2] = true;
                        result++;
                    }

                    initialY -= 1;
                }
            }
            else if (command == 'L') {
                //범위 안이면
                if (initialX - 1 >= 0) {
                    //방문 안했으면
                    if (!visited[initialX - 1][initialY][3] && !visited[initialX][initialY][4]) {
                        visited[initialX - 1][initialY][3] = true;
                        result++;
                    }

                    initialX -= 1;
                }
            }
            else if (command == 'R') {
                //범위 안이면
                if (initialX + 1 <= 10) {
                    //방문 안했으면
                    if (!visited[initialX + 1][initialY][4] && !visited[initialX][initialY][3]) {
                        visited[initialX + 1][initialY][4] = true;
                        result++;
                    }

                    initialX += 1;
                }
            }
        }
        return result;
    }
}
