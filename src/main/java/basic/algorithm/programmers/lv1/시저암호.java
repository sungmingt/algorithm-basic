package basic.algorithm.programmers.lv1;

public class 시저암호 {

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        //A = 65
        //Z = 90
        //a = 97
        //z = 122
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((c <= 90 && 90 < c + n) || (c <= 122 && 122 < c + n)) {
                c = (char) (c + n - 26);
                sb.append(c);
            } else if (c == ' ') {
                sb.append(" ");
            } else {
                c += n;
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
