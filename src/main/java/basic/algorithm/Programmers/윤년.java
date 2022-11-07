package basic.algorithm.Programmers;

public class 윤년 { //2016년
    public String solution(int a, int b) {
        //1월 1일 : 금요일
        //윤년 : 2월 29일까지
        int days = 0;
        String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        for (int i = 1; i <= a-1; i++) {
            switch (i) {
                case 1: case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
                    days += 31;
                    break;
                case 2:
                    days += 29;
                    break;
                case 4: case 6: case 9: case 11 :
                    days += 30;
                    break;
            }
        }
        //answer + b : 총 일수
        return dayOfWeek[(days + b) % 7];
    }
}
