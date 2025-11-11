package basic.algorithm.leetcode;


public class vallidPalindrome_125_twoPointer {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        isPalindrome(str);
    }

    //투포인터 풀이
    private static boolean isPalindrome(String s) {
        //소문자 변환후 공백 제거했을때 앞뒤로 읽는게 같다면 팰린드롬.
        //문자열/숫자를 제외한 모든것 제거 후 소문자 변환

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }

            if (!isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return (48 <= c && c <= 57) || (65 <= c && c <= 90) || (97 <= c && c <= 122);
    }

    //---------------------

    //풀이 2
    private static boolean isPalindrome2(String s) {
        //소문자 변환후 공백 제거했을때 앞뒤로 읽는게 같다면 팰린드롬.
        //문자열/숫자를 제외한 모든것 제거 후 소문자 변환

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = c - '0';

            if ((48 <= c && c <= 57) || (65 <= c && c <= 90) || (97 <= c && c <= 122)) {
                sb.append(c);
            }
        }

        String str = sb.toString().toLowerCase();

        System.out.println(str);

        //abcde 5 2
        //abcd  4 1

        for(int i=0; i<str.length()/2; i++) {
            char fir = str.charAt(i);
            char sec = str.charAt(str.length() - 1 - i);

            if(fir != sec) {
                return false;
            }
        }

        return true;
    }
}