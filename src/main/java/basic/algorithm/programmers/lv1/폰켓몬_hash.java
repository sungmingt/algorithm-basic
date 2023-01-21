package basic.algorithm.programmers.lv1;

import java.util.HashSet;

public class 폰켓몬_hash {

    public int solution(int[] nums) {
        //N마리 중 N/2마리 선택
        //[3, 1, 2, 3]
        //고르는 가짓수 중, 종류수 최대로
        //(nums.length / 2) 만큼 선택 가능

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) hashSet.add(nums[i]);

        return Math.min(nums.length / 2, hashSet.size());
    }
}
