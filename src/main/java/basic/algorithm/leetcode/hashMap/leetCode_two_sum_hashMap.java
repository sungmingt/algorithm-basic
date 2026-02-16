package basic.algorithm.leetcode.hashMap;

import java.util.*;

public class leetCode_two_sum_hashMap {

    //https://leetcode.com/problems/two-sum/description/

    public int[] twoSum(int[] nums, int target) {

        //(target - 현재 요소) 인 숫자가 hashMap에 존재하는지 검사

        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (map.containsKey(need)) {
                answer = new int[]{map.get(need), i};
                break;
            }

            map.put(nums[i], i);
        }

        return answer;
    }
}
