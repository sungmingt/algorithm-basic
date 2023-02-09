package basic.algorithm.programmers.lv1;

public class 소수만들기 {

    public int solution(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int value = nums[i] + nums[j] + nums[k];

                    //자연수 3개의 합이기 때문에 2는 어차피 없으므로 경우에서 제외
                    for (int o = 2; o <= Math.sqrt(value); o++) {
                        if (value % o == 0) {
                            result --;
                            break;
                        }
                    }

                    result ++;
                }
            }
        }

        return result;
    }
}
